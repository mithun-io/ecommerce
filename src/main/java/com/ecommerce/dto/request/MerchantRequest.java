package com.ecommerce.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class MerchantRequest {

    @NotBlank(message = "business name is required")
    private String businessName;

    @NotBlank(message = "owner name is required")
    private String ownerName;

    @Email(message = "invalid email format")
    @NotBlank(message = "business email is required")
    private String businessEmail;

    @NotBlank(message = "business mobile is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "business mobile must be 10 digits")
    private String businessMobile;

    @NotBlank(message = "business address is required")
    private String businessAddress;

    @NotBlank(message = "gst number is required")
    private String gstNumber;

    @NotBlank(message = "pan number is required")
    private String panNumber;

    @NotBlank(message = "business license is required")
    private String businessLicense;
}