package com.trading.orderservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.trading.orderservice.dto.CreateOrderRequest;
import com.trading.orderservice.entity.Order;
import com.trading.orderservice.repository.OrderRepository;
import com.trading.orderservice.service.OrderService;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repo;
    private final KafkaTemplate<String,String> kafka;

    public String createOrder(CreateOrderRequest req) {

        Order order = Order.builder()
                .symbol(req.symbol)
                .side(req.side)
                .quantity(req.quantity)
                .price(req.price)
                .accountId(req.accountId)
                .build();

        repo.save(order);
        kafka.send("orders", order.getOrderId());

        return order.getOrderId();
    }
}