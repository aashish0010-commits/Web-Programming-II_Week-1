package com.Aashish.online_platform.Project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class registercontroller {

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";  
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@RequestParam("email") String email,  
                                     @RequestParam("password") String password) {  
     
        return new ModelAndView("redirect:/login");  
    }
}
