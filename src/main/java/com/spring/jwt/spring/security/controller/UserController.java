package com.spring.jwt.spring.security.controller;

import com.spring.jwt.spring.security.model.User;
import com.spring.jwt.spring.security.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @PostMapping
    public void postUser(@RequestBody User user){
        if(user.getUserName() == null) {
            throw new RuntimeException("Erro no username");
        }
        service.createUser(user);
    }
}
