package com.danieldinu.mealhub.controller;

import com.danieldinu.mealhub.model.Role;
import com.danieldinu.mealhub.model.User;
import com.danieldinu.mealhub.model.utils.RoleType;
import com.danieldinu.mealhub.payload.request.LoginRequest;
import com.danieldinu.mealhub.payload.request.RegisterRequest;
import com.danieldinu.mealhub.payload.response.JWTResponse;
import com.danieldinu.mealhub.payload.response.MessageResponse;
import com.danieldinu.mealhub.security.jwt.JwtAuthenticationManager;
import com.danieldinu.mealhub.security.services.JwtProviderService;
import com.danieldinu.mealhub.security.services.UserDetailsImpl;
import com.danieldinu.mealhub.service.RoleService;
import com.danieldinu.mealhub.service.UserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/public/auth/")
public class AuthenticationController {
    JwtAuthenticationManager authenticationManager;
    UserService userService;
    RoleService roleService;
    PasswordEncoder passwordEncoder;
    JwtProviderService jwtProviderService;

    @Autowired
    public AuthenticationController(JwtAuthenticationManager authenticationManager, UserService userService, RoleService roleService, PasswordEncoder passwordEncoder, JwtProviderService jwtProviderService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.jwtProviderService = jwtProviderService;
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        if (authentication == null) {
            return ResponseEntity.badRequest().body(new MessageResponse("Username of Password invalid!"));
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProviderService.createToken(authentication);

        UserDetailsImpl userDetails = UserDetailsImpl.build(userService.findByName((String) authentication.getPrincipal()));
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).toList();

        return ResponseEntity.ok(
                new JWTResponse(
                        jwt,
                        userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        roles
                )
        );
    }

    @PostMapping("logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok(new MessageResponse("User logged out successfully"));
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest registerRequest) throws MessagingException, UnsupportedEncodingException {
        if (userService.existsByName(registerRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userService.existsByEmail(registerRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        User user = new User(registerRequest.getUsername(), registerRequest.getEmail(), passwordEncoder.encode(registerRequest.getPassword()));

        Set<String> stringRoles = registerRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        if (stringRoles == null) {
            Role userRole = roleService.findByRoleType(RoleType.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            stringRoles.forEach(role -> {
                if ("admin".equals(role)) {
                    Role adminRole = roleService.findByRoleType(RoleType.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);
                } else {
                    Role userRole = roleService.findByRoleType(RoleType.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
                }
            });
        }

        String randomCode = RandomString.make(64);
        user.setVerificationCode(randomCode);
        user.setRoles(roles);
        userService.addUser(user);

//        userService.sendVerificationEmail(user, "http://localhost:3000/login");

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}