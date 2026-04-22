package com.ecommerce.controller;

import com.ecommerce.dto.request.*;
import com.ecommerce.dto.response.ApiResponse;
import com.ecommerce.dto.response.LoginResponse;
import com.ecommerce.dto.response.UserResponse;
import com.ecommerce.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/customer/register")
    public ResponseEntity<ApiResponse<Void>> customerRegistration(@Valid @RequestBody CustomerRequest customerRequest) {
        authService.customerRegistration(customerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(true, "otp sent successfully", null, 201));
    }

    @PostMapping("/merchant/register")
    public ResponseEntity<ApiResponse<Void>> merchantRegistration(@Valid @RequestBody MerchantRequest merchantRequest) {
        authService.merchantRegistration(merchantRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(true, "otp sent successfully", null, 201));
    }

    @PatchMapping("/customer/verify")
    public ResponseEntity<ApiResponse<Void>> verifyCustomerOtp(@Valid @RequestBody OtpRequest otpRequest) {
        authService.verifyCustomerOtp(otpRequest);
        return ResponseEntity.ok(new ApiResponse<>(true, "registration successful", null, 200));
    }

    @PatchMapping("/merchant/verify")
    public ResponseEntity<ApiResponse<Void>> verifyMerchantOtp(@Valid @RequestBody OtpRequest otpRequest) {
        authService.verifyMerchantOtp(otpRequest);
        return ResponseEntity.ok(new ApiResponse<>(true, "registration successful", null, 200));
    }

    @PatchMapping("/resend-otp/{email}")
    public ResponseEntity<ApiResponse<Void>> resendOtp(@PathVariable("email") String email) {
        authService.resendOtp(email);
        return ResponseEntity.ok(new ApiResponse<>(true, "otp resent successfully", null, 200));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(new ApiResponse<>(true, "login successful", authService.login(loginRequest), 200));
    }

    @PatchMapping("/password-change")
    public ResponseEntity<ApiResponse<UserResponse>> passwordChange(@Valid @RequestBody PasswordChangeRequest passwordChangeRequest, Principal principal) {
        return ResponseEntity.ok().body(new ApiResponse<>(true, "password changed successfully", authService.passwordChange(passwordChangeRequest, principal), 200));
    }

    @PatchMapping("/forget-password/{email}")
    public ResponseEntity<ApiResponse<Void>> forgetPassword(@PathVariable("email") String email) {
        authService.forgetPassword(email);
        return ResponseEntity.ok().body(new ApiResponse<>(true, "otp sent successfully, verify to reset password", null, 200));
    }

    @PatchMapping("/password-reset")
    public ResponseEntity<ApiResponse<Void>> passwordReset(@Valid @RequestBody PasswordResetRequest passwordResetRequest) {
        authService.passwordReset(passwordResetRequest);
        return ResponseEntity.ok().body(new ApiResponse<>(true, "password reset successful", null, 200));
    }
}