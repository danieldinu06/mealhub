package com.danieldinu.mealhub.security.services;

import com.danieldinu.mealhub.model.User;
import com.danieldinu.mealhub.repository.UserRepository;
import com.danieldinu.mealhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByName(username);

        if (user == null) {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }

        return UserDetailsImpl.build(user);

    }
}
