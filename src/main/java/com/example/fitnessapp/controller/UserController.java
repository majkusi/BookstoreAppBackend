package com.example.fitnessapp.controller;

import com.example.fitnessapp.service.JwtService;
import com.example.fitnessapp.user.User;
import com.example.fitnessapp.user.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private final UserServiceImpl userService;
    private final JwtService jwtService;

    @GetMapping("/userDetails")
    public ResponseEntity<Optional<User>> getUserDetails(@AuthenticationPrincipal String token) throws IOException {
        if (token == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Optional.empty());
        }
        String email = jwtService.extractUsername(token);
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }
}