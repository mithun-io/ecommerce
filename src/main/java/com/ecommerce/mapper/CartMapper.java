package com.ecommerce.mapper;

import com.ecommerce.dto.request.CartRequest;
import com.ecommerce.dto.response.CartResponse;
import com.ecommerce.entity.Cart;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {

    Cart toCart(CartRequest cartRequest);

    CartResponse toCartResponse(Cart cart);

    List<CartResponse> toCartResponses(List<Cart> carts);
}
