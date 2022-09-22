package com.danieldinu.mealhub.security.jwt;

import com.danieldinu.mealhub.exception.TokenException;
import com.danieldinu.mealhub.security.services.JwtProviderService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProviderService jwtProviderService;

    public JwtAuthenticationFilter(JwtProviderService jwtProviderService) {
        this.jwtProviderService = jwtProviderService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = jwtProviderService.parseToken(request);

            if (token != null && jwtProviderService.validateToken(token)) {
                UsernamePasswordAuthenticationToken authentication = jwtProviderService.validateUserAndGetAuthentication(token);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (TokenException e) {
            SecurityContextHolder.clearContext();
            response.sendError(e.getHttpStatus().value(), e.getMessage());
            return;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        filterChain.doFilter(request, response);
    }
}
