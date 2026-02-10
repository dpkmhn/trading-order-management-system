package com.trading.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.trading.orderservice.dto.CreateOrderRequest;
import com.trading.orderservice.service.OrderService;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    public String create(@Valid @RequestBody CreateOrderRequest req){
        return service.createOrder(req);
    }
}