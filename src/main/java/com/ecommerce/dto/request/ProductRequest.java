package com.ecommerce.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class ProductRequest {

    @NotBlank(message = "title is required")
    private String title;

    @NotBlank(message = "category is required")
    private String category;

    @NotNull(message = "price is required")
    @Positive(message = "price must be greater than zero")
    private Double price;

    @DecimalMin(value = "0.0", message = "rating cannot be negative")
    @DecimalMax(value = "5.0", message = "rating cannot be more than 5")
    private Double rating;

    @NotBlank(message = "brand is required")
    private String brand;

    @NotEmpty(message = "tags cannot be empty")
    private List<String> tags;

    @NotBlank(message = "thumbnail is required")
    private String thumbnail;

    @NotNull(message = "stock is required")
    @PositiveOrZero(message = "stock cannot be negative")
    private Long stock;

    private Long merchantId;
}