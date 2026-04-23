package com.ecommerce.mapper;

import com.ecommerce.dto.request.CartRequest;
import com.ecommerce.dto.response.CartResponse;
import com.ecommerce.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {CartItemMapper.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CartMapper {

    Cart toCart(CartRequest cartRequest);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "customerId", expression = "java(cart.getCustomer().getId())")
    @Mapping(target = "items", source = "cartItems")
    @Mapping(target = "totalCartValue", expression = "java(calculateTotal(cart))")
    CartResponse toCartResponse(Cart cart);

    List<CartResponse> toCartResponses(List<Cart> carts);

    default Double calculateTotal(Cart cart) {
        if (cart == null || cart.getCartItems() == null) return 0.0;

        return cart.getCartItems()
                .stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }
}
