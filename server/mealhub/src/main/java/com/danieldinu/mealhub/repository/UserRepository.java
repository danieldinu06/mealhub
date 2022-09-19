package com.danieldinu.mealhub.repository;

import com.danieldinu.mealhub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String username);
    Boolean existsByName(String username);
    Boolean existsByEmail(String username);
}
