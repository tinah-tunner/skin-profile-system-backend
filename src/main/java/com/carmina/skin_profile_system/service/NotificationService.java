package com.carmina.skin_profile_system.service;

import com.carmina.skin_profile_system.entity.Notification;

import java.util.List;

public interface NotificationService {

    Notification create(String message, String role);

    List<Notification> getByRole(String role);
}