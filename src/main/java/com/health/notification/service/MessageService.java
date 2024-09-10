package com.health.notification.service;

import com.health.notification.dto.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    final String OUTPUT_CHANNEL = "outputChannel-out-0";

    @Autowired
    private StreamBridge streamBridge;

    public void sendMessage(Notification notification) {
        Message<Notification> message = MessageBuilder
                .withPayload(notification)
                .build();
        streamBridge.send(OUTPUT_CHANNEL, message);
    }
}
