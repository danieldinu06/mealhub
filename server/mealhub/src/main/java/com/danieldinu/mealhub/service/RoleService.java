package com.danieldinu.mealhub.service;

import com.danieldinu.mealhub.model.Role;
import com.danieldinu.mealhub.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void addRole(Role role) {
        roleRepository.save(role);
    }

    public void addRoles(List<Role> roles) {
        roleRepository.saveAll(roles);
    }
}
