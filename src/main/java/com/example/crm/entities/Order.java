package com.example.crm.entities;

public record Order(
  String orderId,
  String customerId,
  STATUS status,
  ShippingInfoData shippingInfo,
  double total,
  double discount,
  String cancellationReason
) {
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
