package com.springbootecommerce.controller;

import com.springbootecommerce.entity.Login;
import com.springbootecommerce.entity.Users;
import com.springbootecommerce.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("login") Login login){
        return "html/login";
    }
    @GetMapping("/register")
    public String registerGet() {
        return "/html/register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("user") Users users, HttpServletRequest request) throws ServletException {
        String redirect = loginService.register(users, request);
        return "redirect:" + redirect;
    }
}
