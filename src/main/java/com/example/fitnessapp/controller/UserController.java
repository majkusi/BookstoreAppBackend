package com.example.fitnessapp.controller;

import com.example.fitnessapp.user.User;
import com.example.fitnessapp.user.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserServiceImpl userService;
    
    @GetMapping("/userDetails/{email}")
    public ResponseEntity<Optional<User>> getUserDetails(@PathVariable("email") String email) throws IOException {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }
}
