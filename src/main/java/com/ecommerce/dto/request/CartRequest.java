package com.ecommerce.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CartRequest {

    @NotNull(message = "customer id is required")
    private Long customerId;

    @NotEmpty(message = "items are required")
    private List<CartItemRequest> items;
}