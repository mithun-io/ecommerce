package com.ecommerce.dto.response;

import com.ecommerce.enums.Gender;
import com.ecommerce.enums.UserRole;
import com.ecommerce.enums.UserStatus;

import java.time.LocalDateTime;

public class UserResponse {

    private Long id;

    private String username;

    private String email;

    private String mobile;

    private Gender gender;

    private UserRole userRole;

    private UserStatus userStatus;

    private LocalDateTime createdAt;
}
