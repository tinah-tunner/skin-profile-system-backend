package com.carmina.skin_profile_system.controller;

import com.carmina.skin_profile_system.entity.Notification;
import com.carmina.skin_profile_system.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "*")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/{role}")
    public List<Notification> getNotificationsByRole(
            @PathVariable String role) {

        return notificationService.getByRole(role);
    }
}