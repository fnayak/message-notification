package com.health.notification.controller;

import com.health.notification.dto.Notification;
import com.health.notification.dto.SigninResponse;
import com.health.notification.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/notify")
    public ResponseEntity<String> sendNotification(@RequestBody Notification notification) {
        messageService.sendMessage(notification);
        return new ResponseEntity<>("Notification sent", HttpStatus.OK);
    }
}
