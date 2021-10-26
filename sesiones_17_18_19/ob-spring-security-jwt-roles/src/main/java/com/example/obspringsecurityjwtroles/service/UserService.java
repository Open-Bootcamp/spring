package com.example.obspringsecurityjwtroles.service;


import com.example.obspringsecurityjwtroles.entities.User;
import com.example.obspringsecurityjwtroles.dto.UserDto;

import java.util.List;

public interface UserService {
    User save(UserDto user);
    List<User> findAll();
    User findOne(String username);
}
