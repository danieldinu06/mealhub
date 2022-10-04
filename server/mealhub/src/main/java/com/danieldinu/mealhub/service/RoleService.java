package com.danieldinu.mealhub.service;

import com.danieldinu.mealhub.model.Role;
import com.danieldinu.mealhub.model.utils.RoleType;
import com.danieldinu.mealhub.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Role> findByRoleType(RoleType roleType) {
        return roleRepository.findByRoleType(roleType);
    }
}
