package com.springbootecommerce.service;

import com.springbootecommerce.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public interface LoginService {
    String register(Users users, HttpServletRequest httpServletRequest) throws ServletException;

}
