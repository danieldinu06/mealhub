package com.danieldinu.mealhub.repository;

import com.danieldinu.mealhub.model.Role;
import com.danieldinu.mealhub.model.utils.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleType(RoleType name);
}
