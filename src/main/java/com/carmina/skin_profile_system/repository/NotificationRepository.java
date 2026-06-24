package com.carmina.skin_profile_system.repository;

import com.carmina.skin_profile_system.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository
        extends JpaRepository<Notification, Long> {

    List<Notification> findByRole(String role);
}