package com.ecommerce.dto.response;

import com.ecommerce.enums.ProductStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductResponse {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String title;

    private String category;

    private Double price;

    private Double rating;

    private String brand;

    private List<String> tags;

    private String thumbnail;

    private ProductStatus productStatus;

    private Long stock;

    private Long merchantId;
}