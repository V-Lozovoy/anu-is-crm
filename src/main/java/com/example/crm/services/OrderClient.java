package com.example.crm.services;

import com.example.crm.entities.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "orderClient", url = "${order.base-url}")
public interface OrderClient {

    @GetMapping("/orders/{id}")
    Order getOrderById(@PathVariable("id") String orderId);
}
