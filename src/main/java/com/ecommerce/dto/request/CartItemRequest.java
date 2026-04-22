package com.ecommerce.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CartItemRequest {

    @NotNull(message = "product id is required")
    private Long productId;

    @NotNull(message = "quantity is required")
    @Positive(message = "quantity must be greater than zero")
    private Integer quantity;

    @NotNull(message = "size is required")
    private String size;

    @NotNull(message = "price is required")
    @Positive(message = "price must be greater than zero")
    private Double price;
}
