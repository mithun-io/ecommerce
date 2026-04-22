package com.ecommerce.service;

import com.ecommerce.dto.response.CustomerResponse;
import com.ecommerce.dto.response.MerchantResponse;
import com.ecommerce.dto.response.ProductResponse;
import com.ecommerce.dto.response.UserResponse;
import com.ecommerce.enums.UserStatus;

import java.util.List;

public interface AdminService {

    UserResponse blockUser(Long id);

    UserResponse unblockUser(Long id);

    ProductResponse approveProduct(Long id);

    ProductResponse denyProduct(Long id);

    List<CustomerResponse> getAllCustomers();

    List<MerchantResponse> getAllMerchants();

    List<ProductResponse> getAllProducts();
}
