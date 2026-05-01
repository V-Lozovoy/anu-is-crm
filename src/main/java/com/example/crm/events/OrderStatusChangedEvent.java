package com.example.crm.events;

import com.example.crm.entities.Order;

public record OrderStatusChangedEvent(
  String orderId,
  Order.STATUS previousStatus,
  Order.STATUS currentStatus
) {}
