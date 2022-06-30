package com.javamaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String home(@RequestParam(required = false) String login, String password, Model model) {
        System.out.println("login is: " + login);
        System.out.println("password is: " + password);
        model.addAttribute("login", login);
        // Добавить проверку на логин и пароль, если не совпадает - открывать другую страницу
        return "admin";
    }
}
