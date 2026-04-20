package com.ecommerce.dto.request;

import lombok.Data;

@Data
public class MerchantRequest {

    private String businessName;

    private String ownerName;

    private String businessEmail;

    private String businessMobile;

    private String businessAddress;

    private String gstNumber;

    private String panNumber;

    private String businessLicense;
}
