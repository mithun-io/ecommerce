package com.ecommerce.service;

import com.ecommerce.dto.response.CustomerResponse;
import com.ecommerce.dto.response.MerchantResponse;
import com.ecommerce.dto.response.UserResponse;

import java.util.List;

public interface AdminService {

    public UserResponse blockUser(Long id);

    public UserResponse unblockUser(Long id);

    public List<CustomerResponse> getAllCustomers();

    public List<MerchantResponse> getAllMerchants();
}
