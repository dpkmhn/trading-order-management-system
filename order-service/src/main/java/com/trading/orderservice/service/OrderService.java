package com.trading.orderservice.service;

import com.trading.orderservice.dto.CreateOrderRequest;

public interface OrderService {
    String createOrder(CreateOrderRequest req);
}