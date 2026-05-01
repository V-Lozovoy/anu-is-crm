package com.example.crm.services;

import com.example.crm.entities.Order;
import com.example.crm.events.OrderStatusChangedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final OrderClient orderClient;
    private final CustomerService customerService;
    private final JavaMailSender mailSender;
    private final String fromAddress;

    public NotificationService(
      OrderClient orderClient,
      CustomerService customerService,
      JavaMailSender mailSender,
      @Value("${notification.mail.from}") String fromAddress
    ) {
        this.orderClient = orderClient;
        this.customerService = customerService;
        this.mailSender = mailSender;
        this.fromAddress = fromAddress;
    }

    public void notifyOrderChange(OrderStatusChangedEvent event) {
        Order order = orderClient.getOrderById(event.orderId());
        String email = customerService.getEmail(order.customerId());
        if (email == null) {
            return;
        }

        String body = "Order %s status is changed from %s to %s".formatted(
          event.orderId(), event.previousStatus(), event.currentStatus()
        );
        String subject = "Order %s status update".formatted(event.orderId());
        sendEmail(email, subject, body);
    }

    private void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromAddress);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}
