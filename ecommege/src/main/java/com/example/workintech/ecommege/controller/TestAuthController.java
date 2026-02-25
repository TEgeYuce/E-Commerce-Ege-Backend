package com.example.workintech.ecommege.controller;
import java.util.Map;
import java.util.HashMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;


@RestController
public class TestAuthController {
    @GetMapping("/test/protected")
    public Map<String, Object> testProtectedEndpoint() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Map<String, Object> response = new HashMap<>();

        if (auth != null && auth.isAuthenticated()) {
            response.put("status", "success");
            response.put("message", "JWT Authentication Successful!!");
            response.put("user", auth.getName());
            response.put("authorities", auth.getAuthorities());

            System.out.println("\n Protected Endpoint Access Successful!!");
            System.out.println("User: " + auth.getName());
            System.out.println("Authorities: " + auth.getAuthorities());
            System.out.println("==================================\n");

        } else {
            response.put("status", "error");
            response.put("message", "Authentication Failed!!");
        }
        return response;
    }

    @GetMapping("/test/public")
    public Map<String, Object> testPublicEndpoint() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "This is a public endpoint -> No authentication required!!");

        System.out.println("Public Endpoint Accessed...");
        return response;

    }


}

