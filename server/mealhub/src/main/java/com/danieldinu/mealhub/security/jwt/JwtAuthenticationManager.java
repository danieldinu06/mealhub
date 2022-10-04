package com.danieldinu.mealhub.security.jwt;

import com.danieldinu.mealhub.security.SecurityConfiguration;
import com.danieldinu.mealhub.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtAuthenticationManager implements AuthenticationManager {
    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public JwtAuthenticationManager(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final String username = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();

        if ( !SecurityConfiguration.passwordEncoder()
                .matches((CharSequence) authentication.getCredentials(), userDetailsService.loadUserByUsername(username).getPassword())) {
            return null;
        };

        if (username.equals("")) {
            return null;
        }

        UserDetails user;
        try {
            user = userDetailsService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e) {
            return null;
        }

        return createSuccessfulAuthentication(authentication, user);
    }

    private Authentication createSuccessfulAuthentication(final Authentication authentication, final UserDetails user) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), authentication.getCredentials(), user.getAuthorities());
        token.setDetails(authentication.getDetails());

        return token;
    }
}
