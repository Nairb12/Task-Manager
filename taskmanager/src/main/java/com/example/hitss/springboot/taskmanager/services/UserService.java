package com.example.hitss.springboot.taskmanager.services;

import java.util.List;

import com.example.hitss.springboot.taskmanager.models.User;


public interface UserService {
    List<User> findAll();

    User save(User user);

    boolean existsByUsername(String username);
}
