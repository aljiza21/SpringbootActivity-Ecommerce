package com.springbootecommerce.service;

import com.springbootecommerce.entity.Role;
import com.springbootecommerce.entity.Users;
import com.springbootecommerce.repository.RoleRepository;
import com.springbootecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class LoginServiceImplementation implements LoginService{

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private RoleRepository roleRepository;
    private UserRepository userRepository;

    @Autowired
    public LoginServiceImplementation(BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository, UserRepository userRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String register(Users users, HttpServletRequest httpServletRequest) throws ServletException {
        String redirect;
        String password = users.getPassword();
        users.setPassword(bCryptPasswordEncoder.encode(password));
        List<Role> roles = new ArrayList<>();
        if (users.getRole().equalsIgnoreCase("Buyer")) {
            roles.add(roleRepository.findById(2).get());
            redirect = "/login";
        } else {
            roles.add(roleRepository.findById(1).get());
            redirect = "/login";
        }

        users.setRoles(roles);
        userRepository.save(users);
        httpServletRequest.login(users.getEmail(), password);
        return redirect;
    }
}
