package com.carmina.skin_profile_system.controller;

import com.carmina.skin_profile_system.dto.LoginRequest;
import com.carmina.skin_profile_system.dto.LoginResponse;
import com.carmina.skin_profile_system.dto.RegisterRequest;
import com.carmina.skin_profile_system.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
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

    // ===============================
    // REGISTER (PUBLIC)
    // ===============================
    @PostMapping("/register")
    public LoginResponse register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    // ===============================
    // LOGIN (PUBLIC)
    // ===============================
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }

    // ===============================
    // GET CURRENT USER PROFILE (SECURE)
    // ===============================
    @GetMapping("/me")
    @PreAuthorize("isAuthenticated()")
    public LoginResponse getCurrentUser() {
        return userService.getCurrentUser();
    }

    // ===============================
    // ADMIN ONLY - GET ALL USERS
    // ===============================
    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public List<?> getUsers() {
        return userService.getAllUsers();
    }

    // ===============================
    // ADMIN ONLY - DELETE USER
    // ===============================
    @DeleteMapping("/users/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }
}