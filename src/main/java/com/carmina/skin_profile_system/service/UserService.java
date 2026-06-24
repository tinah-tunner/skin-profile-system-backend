package com.carmina.skin_profile_system.service;

import com.carmina.skin_profile_system.dto.LoginRequest;
import com.carmina.skin_profile_system.dto.LoginResponse;
import com.carmina.skin_profile_system.dto.RegisterRequest;
import com.carmina.skin_profile_system.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    // AUTH (DTO-based - recommended)
    LoginResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

    // USER MANAGEMENT (Entity-based - admin/internal use)
    User createUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}