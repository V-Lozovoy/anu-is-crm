package com.example.crm.services;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CustomerService {

    private static final Map<String, String> CUSTOMER_EMAILS = Map.of(
      "customer-1", "alice@example.com",
      "customer-2", "bob@example.com",
      "customer-3", "charlie@example.com"
    );

    public String getEmail(String customerId) {
        return CUSTOMER_EMAILS.get(customerId);
    }
}
