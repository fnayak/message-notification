package com.health.notification.config;

import java.util.function.Consumer;
import java.util.function.Supplier;

import com.health.notification.dto.Notification;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;


@Configuration
public class KafkaProcessorConfig {

    @Bean
    public Supplier<Message<Notification>> outputChannel() {
        return () -> {
            Notification notification = Notification.builder()
                    .title("title")
                    .message("message")
                    .recipient("recipient").build();
            return MessageBuilder.withPayload(notification).build();
        };
    }

    @Bean
    public Consumer<Message<Notification>> inputChannel() {
        return message -> {
            Notification notification = message.getPayload();
            System.out.println("Received Notification: " + notification.getMessage());
        };
    }
}
