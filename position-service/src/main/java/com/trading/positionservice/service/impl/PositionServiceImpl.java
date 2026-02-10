package com.trading.positionservice.service.impl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl {

    @KafkaListener(topics="orders")
    public void consume(String orderId){
        System.out.println("Updating position for order: "+orderId);
    }
}