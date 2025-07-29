package com.systemzarzadzaniaapteka.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private LocalDateTime remindAt;

    @ManyToOne
    private AppUser recipient;

    public Reminder() {
    }

    public Reminder(String message, LocalDateTime remindAt, AppUser recipient) {
        this.message = message;
        this.remindAt = remindAt;
        this.recipient = recipient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getRemindAt() {
        return remindAt;
    }

    public void setRemindAt(LocalDateTime remindAt) {
        this.remindAt = remindAt;
    }

    public AppUser getRecipient() {
        return recipient;
    }

    public void setRecipient(AppUser recipient) {
        this.recipient = recipient;
    }

    public void sendReminder() {
        if (recipient != null) {
            System.out.println("Sending reminder to " + recipient.getName() + ": " + message + " at " + remindAt);
        } else {
            System.out.println("Reminder: " + message + " at " + remindAt);
        }
    }
}