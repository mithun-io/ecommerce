package com.ecommerce.controller;

import com.ecommerce.dto.response.*;
import com.ecommerce.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PatchMapping("/block/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<UserResponse>> blockUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new ApiResponse<>(true, "user blocked successfully", adminService.blockUser(id), 200));
    }

    @PatchMapping("/unblock/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<UserResponse>> unblockUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new ApiResponse<>(true, "user unblocked successfully", adminService.unblockUser(id), 200));
    }

    @PatchMapping("/approve/product/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<ProductResponse>> approveProducts(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new ApiResponse<>(true, "product approved", adminService.approveProduct(id), 200));
    }

    @PatchMapping("/deny/product/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<ProductResponse>> denyProducts(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new ApiResponse<>(true, "product denied", adminService.denyProduct(id), 200));
    }

    @GetMapping("/customers")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<List<CustomerResponse>>> getAllCustomers() {
        return ResponseEntity.ok(new ApiResponse<>(true, "customers fetched successfully", adminService.getAllCustomers(), 200));
    }

    @GetMapping("/merchants")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<List<MerchantResponse>>> getAllMerchants() {
        return ResponseEntity.ok(new ApiResponse<>(true, "merchants fetched successfully", adminService.getAllMerchants(), 200));
    }

    @GetMapping("/products")
    @PreAuthorize("hasAnyRole('ADMIN', 'CUSTOMER', 'MERCHANT')")
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getAllProducts() {
        return ResponseEntity.ok(new ApiResponse<>(true, "products fetched successfully", adminService.getAllProducts(), 200));
    }
}