package com.example.crm.entities;

public class Order {
    public enum STATUS {
        UNSET,
        NEW,
        PENDING,
        APPROVED,
        CANCELLED,
        SHIPPED,
        FULFILLED;
    }
}
