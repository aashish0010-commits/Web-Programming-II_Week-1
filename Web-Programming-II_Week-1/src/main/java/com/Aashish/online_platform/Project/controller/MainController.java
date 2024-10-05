package com.Aashish.online_platform.Project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Aashish.online_platform.Project.dto.MyUserDto;
import com.Aashish.online_platform.Project.model.UserModel;
import com.Aashish.online_platform.Project.service.UserService;

import jakarta.validation.Valid;

@Controller
public class MainController {

    private final UserService userService;

    // Constructor-based dependency injection without @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String displayHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String displayRegistrationForm(Model model) {
        model.addAttribute("user", new MyUserDto());
        return "register";
    }

    @PostMapping("/register/save")
    public String handleUserRegistration(@Valid @ModelAttribute("user") MyUserDto userDto,
                                         BindingResult bindingResult,
                                         Model model) {
        if (isEmailAlreadyRegistered(userDto.getEmail())) {
            bindingResult.rejectValue("email", "email.exists", "An account with this email already exists.");
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("user", userDto);
            return "register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    private boolean isEmailAlreadyRegistered(String email) {
        UserModel user = userService.findUserByEmail(email);
        return user != null && email != null && !email.isEmpty();
    }

    @GetMapping("/home")
    public String displayUserList(Model model) {
        List<MyUserDto> allUsers = userService.findAllUsers();
        model.addAttribute("home", allUsers);
        return "home";
    }

    @GetMapping("/login")
    public String displayLoginForm() {
        return "login";
    }
}
