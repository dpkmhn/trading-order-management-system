package com.trading.orderservice.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class CreateOrderRequest {

    @NotBlank public String symbol;
    @NotBlank public String side;
    @Min(1) public Integer quantity;
    public BigDecimal price;
    @NotBlank public String accountId;
}