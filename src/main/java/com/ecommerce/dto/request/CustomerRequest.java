package com.ecommerce.dto.request;

import com.ecommerce.enums.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerRequest {

    private String name;

    private String email;

    private String mobile;

    private String password;

    private Gender gender;

    private LocalDate dateOfBirth;

    private String address;
}
