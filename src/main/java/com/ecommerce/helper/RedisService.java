package com.ecommerce.helper;

import com.ecommerce.dto.request.CustomerRequest;
import com.ecommerce.dto.request.MerchantRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@Component
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper objectMapper;

    private static final String OTP_PREFIX = "OTP:";
    private static final String PENDING_CUSTOMER_PREFIX = "PENDING:CUSTOMER:";
    private static final String PENDING_MERCHANT_PREFIX = "PENDING:MERCHANT:";

    public Integer getOtp(String email) {
        return (Integer) redisTemplate.opsForValue().get(OTP_PREFIX + email);
    }

    public CustomerRequest getPendingCustomer(String email) {
        try {
            String json = (String) redisTemplate.opsForValue().get(PENDING_CUSTOMER_PREFIX + email);
            if (json == null) return null;
            return objectMapper.readValue(json, CustomerRequest.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("error while parsing customer json from redis", e);
        }
    }

    public MerchantRequest getPendingMerchant(String email) {
        try {
            String json = (String) redisTemplate.opsForValue().get(PENDING_MERCHANT_PREFIX + email);
            if (json == null) return null;
            return objectMapper.readValue(json, MerchantRequest.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("error while parsing customer json from redis", e);
        }
    }

    public void storeOtp(String email, Integer otp) {
        redisTemplate.opsForValue().set(OTP_PREFIX + email, otp, Duration.ofMinutes(5));
    }

    public void storePendingCustomer(String email, CustomerRequest customerRequest) {
        try {
            String json = objectMapper.writeValueAsString(customerRequest);
            redisTemplate.opsForValue().set(PENDING_CUSTOMER_PREFIX + email, json, Duration.ofMinutes(5));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("error while parsing customer json from redis", e);
        }
    }

    public void storePendingMerchant(String email, MerchantRequest merchantRequest) {
        try {
            String json = objectMapper.writeValueAsString(merchantRequest);
            redisTemplate.opsForValue().set(PENDING_MERCHANT_PREFIX + email, json, Duration.ofMinutes(5));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("error while parsing customer json from redis", e);
        }
    }

    public void deleteOtp(String email) {
        redisTemplate.delete(OTP_PREFIX + email);
    }

    public void deletePendingCustomer(String email) {
        redisTemplate.delete(PENDING_CUSTOMER_PREFIX + email);
    }

    public void deletePendingMerchant(String email) {
        redisTemplate.delete(PENDING_MERCHANT_PREFIX + email);
    }

    public boolean isPendingCustomerExists(String email) {
        return getPendingCustomer(email) != null;
    }

    public boolean isPendingMerchantExists(String email) {
        return getPendingMerchant(email) != null;
    }
}