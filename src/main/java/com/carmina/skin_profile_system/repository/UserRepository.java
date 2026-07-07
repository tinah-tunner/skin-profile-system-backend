package com.carmina.skin_profile_system.repository;

import com.carmina.skin_profile_system.entity.Role;
import com.carmina.skin_profile_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    long countByRole(Role role);
}