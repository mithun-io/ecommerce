package com.ecommerce.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class CartResponse {

    private Long id;

    private Long customerId;

    private List<CartItemResponse> items;

    private Double totalCartValue;
}
