package com.Aashish.online_platform.Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Aashish.online_platform.Project.dto.UserDto;
import com.Aashish.online_platform.Project.model.User;
import com.Aashish.online_platform.Project.service.UserService;

import jakarta.validation.Valid;

@Controller
public class MainController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto usersDto,
                               BindingResult result,
                               Model model) {
        User existingUser = userService.findUserByEmail(usersDto.getEmail());

        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", "", "There is already an account registered with the same email");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", usersDto);
            return "register";
        }

        userService.saveUser(usersDto);
        return "redirect:/register?success";
    }

    @GetMapping("/home")
    public String users(Model model) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("home", users);
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
