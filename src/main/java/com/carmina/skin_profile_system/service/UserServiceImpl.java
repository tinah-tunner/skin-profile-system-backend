package com.carmina.skin_profile_system.service;

import com.carmina.skin_profile_system.dto.LoginRequest;
import com.carmina.skin_profile_system.dto.LoginResponse;
import com.carmina.skin_profile_system.dto.RegisterRequest;
import com.carmina.skin_profile_system.entity.User;
import com.carmina.skin_profile_system.repository.UserRepository;
import com.carmina.skin_profile_system.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.carmina.skin_profile_system.entity.Role;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

private final UserRepository userRepository;
private final PasswordEncoder passwordEncoder;
private final JwtService jwtService;

public UserServiceImpl(
        UserRepository userRepository,
        PasswordEncoder passwordEncoder,
        JwtService jwtService
) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtService = jwtService;
}

@Override
public LoginResponse register(RegisterRequest request) {

    User user = new User();

    user.setEmail(request.getEmail());

    user.setPassword(
            passwordEncoder.encode(request.getPassword())
    );

    user.setRole(Role.valueOf(request.getRole().toUpperCase()));

    User savedUser = userRepository.save(user);

    String token = jwtService.generateToken(
            savedUser.getEmail(),
            savedUser.getRole().name()
    );

    return new LoginResponse(
            token,
            savedUser.getRole().name(),
            savedUser.getEmail()
    );
}

@Override
public User createUser(User user) {

    user.setPassword(
            passwordEncoder.encode(user.getPassword())
    );

    return userRepository.save(user);
}

@Override
public LoginResponse login(LoginRequest request) {

    User user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() ->
                    new RuntimeException("Invalid credentials"));

    if (!passwordEncoder.matches(
            request.getPassword(),
            user.getPassword())) {

        throw new RuntimeException("Invalid credentials");
    }

    String token = jwtService.generateToken(
            user.getEmail(),
            user.getRole().name()
    );

    return new LoginResponse(
            token,
            user.getRole().name(),
            user.getEmail()
    );
}

@Override
public List<User> getAllUsers() {
    return userRepository.findAll();
}

@Override
public Optional<User> getUserById(Long id) {
    return userRepository.findById(id);
}


@Override
public User updateUser(Long id, User user) {

    User existingUser = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

    existingUser.setEmail(user.getEmail());

    if (user.getPassword() != null && !user.getPassword().isEmpty()) {
        existingUser.setPassword(
                passwordEncoder.encode(user.getPassword())
        );
    }

    existingUser.setRole(user.getRole());

    return userRepository.save(existingUser);
}

@Override
public void deleteUser(Long id) {
    userRepository.deleteById(id);
}

}
