package com.example.obspringsecurityjwtroles.service;

import com.example.obspringsecurityjwtroles.entities.Role;
import com.example.obspringsecurityjwtroles.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        return roleRepository.findRoleByName(name);
    }
}
