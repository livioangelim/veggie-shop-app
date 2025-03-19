package com.veggieshop.service;

import com.veggieshop.dto.OrderDto;
import com.veggieshop.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(OrderDto orderDto);
    Order getOrderById(Long orderId);
    List<Order> getAllOrders();
    void updateOrder(Long orderId, OrderDto orderDto);
    void deleteOrder(Long orderId);
}