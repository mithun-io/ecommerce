package com.ecommerce.mapper;

import com.ecommerce.dto.request.OrderRequest;
import com.ecommerce.dto.response.OrderResponse;
import com.ecommerce.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    Order toOrder(OrderRequest orderRequest);

    OrderResponse toOrderResponse(Order order);

    List<OrderResponse> toOrderResponses(List<Order> orders);
}
