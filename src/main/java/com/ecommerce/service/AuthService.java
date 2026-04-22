package com.ecommerce.service;

import com.ecommerce.dto.request.*;
import com.ecommerce.dto.response.LoginResponse;
import com.ecommerce.dto.response.UserResponse;

import java.security.Principal;

public interface AuthService {

    void customerRegistration(CustomerRequest customerRequest);

    void merchantRegistration(MerchantRequest merchantRequest);

    void verifyCustomerOtp(OtpRequest otpRequest);

    void verifyMerchantOtp(OtpRequest otpRequest);

    void resendOtp(String email);

    LoginResponse login(LoginRequest loginRequest);

    UserResponse passwordChange(PasswordChangeRequest passwordChangeRequest, Principal principal);

    void forgetPassword(String email);

    void passwordReset(PasswordResetRequest passwordResetRequest);
}
