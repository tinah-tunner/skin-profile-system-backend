package com.carmina.skin_profile_system.controller;

import com.carmina.skin_profile_system.dto.LoginRequest;
import com.carmina.skin_profile_system.dto.LoginResponse;
import com.carmina.skin_profile_system.dto.RegisterRequest;
import com.carmina.skin_profile_system.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // ✅ REGISTER (safe DTO instead of entity)
    @PostMapping("/register")
    public LoginResponse register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    // ✅ LOGIN RETURNS JWT
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }

    // ⚠️ ADMIN ONLY ENDPOINT (optional later security restriction)
    @GetMapping("/users")
    public List<?> getUsers() {
        return userService.getAllUsers();
    }
}