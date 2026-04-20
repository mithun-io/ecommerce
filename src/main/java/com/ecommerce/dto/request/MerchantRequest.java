package com.ecommerce.dto.request;

import com.ecommerce.entity.User;
import com.ecommerce.enums.UserStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

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
