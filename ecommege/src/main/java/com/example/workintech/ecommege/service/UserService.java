package com.example.workintech.ecommege.service;
import com.example.workintech.ecommege.dto.UserSignupRequest;
import com.example.workintech.ecommege.dto.UserResponse;
import com.example.workintech.ecommege.dto.LoginRequest;
import com.example.workintech.ecommege.dto.BackendResponse;


public interface UserService {

    UserResponse getByEmail(String email);
    BackendResponse save(UserSignupRequest signupRequest);
    UserResponse verify(String token);
    UserResponse login(LoginRequest loginRequest);

}

