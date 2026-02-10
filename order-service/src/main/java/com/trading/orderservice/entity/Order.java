package com.trading.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Order {

    @Id
    private String orderId;

    private String symbol;
    private String side;
    private Integer quantity;
    private BigDecimal price;
    private String status;
    private String accountId;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.orderId = "ORD-" + UUID.randomUUID();
        this.status = "NEW";
        this.createdAt = LocalDateTime.now();
    }
}