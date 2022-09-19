package com.danieldinu.mealhub.security.services;

import com.danieldinu.mealhub.model.utils.RoleType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface IJwtProviderService {
    String createToken(Authentication authentication);
    Authentication validateUserAndGetAuthentication(String token);
    String getUsername(String token);
    String parseToken(HttpServletRequest request);
    boolean validateToken(String token);
}
