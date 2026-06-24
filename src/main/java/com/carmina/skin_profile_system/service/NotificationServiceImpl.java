package com.carmina.skin_profile_system.service;

import com.carmina.skin_profile_system.entity.Notification;
import com.carmina.skin_profile_system.repository.NotificationRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository repo;

    public NotificationServiceImpl(NotificationRepository repo) {
        this.repo = repo;
    }

    @Override
    public Notification create(String message, String role) {

        Notification n = new Notification();
        n.setMessage(message);
        n.setRole(role);
        n.setReadStatus(false);

        return repo.save(n);
    }

    @Override
    public List<Notification> getByRole(String role) {
        return repo.findByRole(role);
    }
}