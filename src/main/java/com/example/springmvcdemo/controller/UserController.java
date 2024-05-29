package com.example.springmvcdemo.controller;

import com.example.springmvcdemo.model.User;
import com.example.springmvcdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/createUser")
    public String createUser() {
        return "createUser";
    }

    @PostMapping("/saveUser")
    public String saveUser(User user, Model model) {
        userService.save(user);
        model.addAttribute("message", "User created successfully");
        return "welcome";
    }
}
