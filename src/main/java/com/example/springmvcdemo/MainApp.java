package com.example.springmvcdemo;

import com.example.springmvcdemo.config.WebConfig;
import com.example.springmvcdemo.model.User;
import com.example.springmvcdemo.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user = new User();
        user.setEmail("user@example.com");
        user.setUsername("exampleUser");
        user.setPassword("password123");

        userService.save(user);
    }
}
