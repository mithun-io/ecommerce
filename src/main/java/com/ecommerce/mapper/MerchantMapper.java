package com.ecommerce.mapper;

import com.ecommerce.dto.request.MerchantRequest;
import com.ecommerce.dto.response.MerchantResponse;
import com.ecommerce.entity.Merchant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MerchantMapper {

    Merchant toMerchant(MerchantRequest merchantRequest);

    MerchantResponse toMerchantResponse(Merchant merchant);

    List<MerchantResponse> toMerchantResponses(List<Merchant> merchants);
}
