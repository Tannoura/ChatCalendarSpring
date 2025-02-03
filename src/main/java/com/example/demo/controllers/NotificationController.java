package com.example.demo.controllers;

import com.example.demo.entities.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "*")


public class NotificationController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @PostMapping("/send")
    public void sendNotification(@RequestParam String senderId, @RequestParam String receiverId, @RequestBody Notification notification) {
        // Ajouter l'expéditeur à la notification
        notification.setSenderId(senderId);

        // Envoyer la notification à l'utilisateur cible via WebSocket
        messagingTemplate.convertAndSend("/topic/notifications/" + receiverId, notification);
    }
}
