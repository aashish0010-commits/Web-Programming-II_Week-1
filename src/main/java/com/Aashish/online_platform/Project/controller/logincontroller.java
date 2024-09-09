package com.Aashish.online_platform.Project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class logincontroller {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@RequestParam("username") String username, 
                                  @RequestParam("password") String password) {
        if(username.equals("admin") && password.equals("password")) {
            return new ModelAndView("redirect:/home");
        } else {
            return new ModelAndView("login", "error", "Invalid credentials");
        }
    }
}
