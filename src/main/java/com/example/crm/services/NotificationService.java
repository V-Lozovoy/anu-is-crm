package com.example.crm.services;

import com.example.crm.events.OrderStatusChangedEvent;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void notifyOrderChange(OrderStatusChangedEvent event) {
        // Here you would typically process the event, e.g., send a push notification, email, etc.
        System.out.println("Order %s: %s → %s".formatted(
                event.orderId(), event.previousStatus(), event.currentStatus()
        ));
        // Todo: get order by id from order microservice
        // Todo: get customer from order
        // Todo: send email to customer
    }
}
