package com.ecommerce.dto.request;

import com.ecommerce.enums.Gender;
import lombok.Data;

@Data
public class UserRequest {

    private String username;

    private String email;

    private String mobile;

    private String password;

    private Gender gender;
}
