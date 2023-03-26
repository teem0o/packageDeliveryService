package com.flatrock.identityservice.service;

import com.flatrock.identityservice.entity.UserCredential;
import com.flatrock.identityservice.repository.UserCredentialRepository;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class AuthService {

    @Autowired
    private UserCredentialRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String saveUser(UserCredential credential) {
//        if (repository.findByName(credential.getName()).isPresent()) {
//            return "user already exists";
//        }
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
//        if (credential.getRoles() == null || credential.getRoles().isEmpty()) {
//            credential.setRoles(new HashSet<>(List.of("ROLE_CLIENT")));
//        }
        repository.save(credential);
        return "user added to the system";
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }


}