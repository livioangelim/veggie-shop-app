package com.veggieshop.controller;

import com.veggieshop.dto.OrderDto;
import com.veggieshop.model.Order;
import com.veggieshop.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCheckout() {
        OrderDto orderDto = new OrderDto();
        orderDto.setCustomerId(1L);
        orderDto.setProductId(1L);
        orderDto.setQuantity(2);

        Order order = new Order();
        order.setId(1L);
        order.setCustomerId(orderDto.getCustomerId());
        order.setOrderItems(null); // Assuming order items are set in the service

        when(orderService.createOrder(any(OrderDto.class))).thenReturn(order);

        ResponseEntity<Order> response = orderController.checkout(orderDto);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(order.getId(), response.getBody().getId());
        verify(orderService, times(1)).createOrder(orderDto);
    }

    @Test
    void testOrderConfirmation() {
        Long orderId = 1L;
        Order order = new Order();
        order.setId(orderId);

        when(orderService.getOrderById(orderId)).thenReturn(order);

        ResponseEntity<Order> response = orderController.orderConfirmation(orderId);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(orderId, response.getBody().getId());
        verify(orderService, times(1)).getOrderById(orderId);
    }
}