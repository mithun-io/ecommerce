package com.ecommerce.dto.request;

import com.ecommerce.enums.Gender;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserRequest {

    @NotBlank(message = "username is required")
    private String username;

    @Email(message = "invalid email format")
    @NotBlank(message = "email is required")
    private String email;

    @NotBlank(message = "mobile is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "mobile must be 10 digits")
    private String mobile;

    @NotBlank(message = "password is required")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "password must be at least 8 characters and include uppercase, lowercase, number and special character")
    private String password;

    @NotNull(message = "gender is required")
    private Gender gender;
}