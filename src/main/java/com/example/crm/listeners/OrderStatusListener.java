package com.example.crm.listeners;

import com.example.crm.events.OrderStatusChangedEvent;
import com.example.crm.services.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusListener {

    private final NotificationService notificationService;

    public OrderStatusListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = "notification-service.order-status")
    public void handle(OrderStatusChangedEvent event) {
        notificationService.notifyOrderChange(event);
    }
}
