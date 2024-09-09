package com.Aashish.online_platform.Project.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hellocontroller {

    @GetMapping("/")
    public String home(Model model) {
        List<String> ourCourses = Arrays.asList(
            "Introduction to Programming",
            "Web Development",
            "Data Science",
            "Digital Marketing",
            "Cybersecurity Basics"
        );

        model.addAttribute("OurCourses", ourCourses);
        return "home"; 
    }

    @GetMapping("/home")
    public String showHomePage(Model model) {
        return home(model);
    }
}
