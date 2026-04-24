package com.ecommerce.mapper;

import com.ecommerce.dto.request.OrdersRequest;
import com.ecommerce.dto.response.OrdersResponse;
import com.ecommerce.entity.Orders;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CartItemMapper.class})
public interface OrdersMapper {

    Orders toOrder(OrdersRequest orderRequest);

    OrdersResponse toOrderResponse(Orders orders);

    List<OrdersResponse> toOrderResponses(List<Orders> orders);
}
