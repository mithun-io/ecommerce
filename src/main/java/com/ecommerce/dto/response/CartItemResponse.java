package com.ecommerce.dto.response;

import lombok.Data;

@Data
public class CartItemResponse {

    private Long id;

    private Integer quantity;

    private String size;

    private Double price;

    private ProductResponse product;
}
