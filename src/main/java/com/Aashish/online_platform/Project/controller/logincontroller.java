package com.Aashish.online_platform.Project.controller;

import com.Aashish.online_platform.Project.dto.LoginRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/login")
    public ModelAndView showLoginPage(@RequestParam(value = "error", required = false) String error) {
        ModelAndView modelAndView = new ModelAndView("login");

        modelAndView.addObject("loginRequest", new LoginRequest());

        if (error != null) {
            modelAndView.addObject("error", "Invalid credentials. Please try again.");
        }
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@ModelAttribute("loginRequest") LoginRequest loginRequest) {

        if (loginRequest.getEmail().equals("admin@example.com") && loginRequest.getPassword().equals("password")) {
            return new ModelAndView("redirect:/home");
        } else {
            return new ModelAndView("redirect:/login?error=true");
        }
    }
}
