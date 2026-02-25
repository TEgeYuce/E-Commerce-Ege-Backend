package com.example.workintech.ecommege.controller;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import com.example.workintech.ecommege.service.UserService;
import com.example.workintech.ecommege.dto.UserSignupRequest;
import com.example.workintech.ecommege.dto.UserResponse;
import com.example.workintech.ecommege.dto.LoginRequest;
import com.example.workintech.ecommege.dto.BackendResponse;


@RestController
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private final UserService userService;

    @PostMapping("/signup")
    public BackendResponse signup(@Validated @RequestBody UserSignupRequest signupRequest) {
        return userService.save(signupRequest);
    }

    @PostMapping("/login")
    public UserResponse login(@Validated @RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }

    @GetMapping("/verify")
    public UserResponse verify(@RequestParam("token") String token) {
        return userService.verify(token);
    }
}



