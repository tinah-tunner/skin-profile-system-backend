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
    public Notification create(String type, String message) {

        Notification notification = new Notification();

        notification.setType(type);
        notification.setMessage(message);

        return repo.save(notification);
    }

    @Override
    public List<Notification> getAll() {
        return repo.findAllByOrderByCreatedAtDesc();
    }
}