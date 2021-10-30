package com.example.obspringsecurityjwtroles.service;


import com.example.obspringsecurityjwtroles.entities.Role;

public interface RoleService {
    Role findByName(String name);
}
