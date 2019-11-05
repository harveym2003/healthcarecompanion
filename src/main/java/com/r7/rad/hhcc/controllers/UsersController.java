package com.r7.rad.hhcc.controllers;

import com.r7.rad.hhcc.data.User;
import com.r7.rad.hhcc.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UsersController {

    @Autowired
    UsersRepository usersRepository;
    @PostMapping
    public User register(@RequestBody User user) {
        usersRepository.save(user);
        return user;
    }
}
