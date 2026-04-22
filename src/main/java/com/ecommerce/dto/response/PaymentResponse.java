package com.ecommerce.dto.response;

import com.ecommerce.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {

    private String name;

    private String email;

    private String mobile;

    private String orderId;

    private String paymentId;

    private String key;

    private Double amount;

    private String currency;

    private PaymentStatus status;

    private String callBackUrl;
}
