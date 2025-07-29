package com.systemzarzadzaniaapteka.controller;
import com.systemzarzadzaniaapteka.model.Notification;
import com.systemzarzadzaniaapteka.service.NotificationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public List<Notification> getAll() {
        return notificationService.getAll();
    }

    @PostMapping
    public Notification send(@RequestBody @Valid Notification notification) {
        return notificationService.send(notification);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        notificationService.delete(id);
    }
}
