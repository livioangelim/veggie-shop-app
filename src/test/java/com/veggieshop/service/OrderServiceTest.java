package com.veggieshop.service;

import com.veggieshop.dto.OrderDto;
import com.veggieshop.exception.InsufficientInventoryException;
import com.veggieshop.exception.ResourceNotFoundException;
import com.veggieshop.model.Order;
import com.veggieshop.model.Product;
import com.veggieshop.repository.OrderRepository;
import com.veggieshop.repository.ProductRepository;
import com.veggieshop.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateOrder_Success() {
        Product product = new Product();
        product.setId(1L);
        product.setInventory(10);
        
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(orderRepository.save(any(Order.class))).thenReturn(new Order());

        OrderDto orderDto = new OrderDto();
        orderDto.setProductId(1L);
        orderDto.setQuantity(2);

        Order order = orderService.createOrder(orderDto);

        assertNotNull(order);
        verify(productRepository).findById(1L);
        verify(orderRepository).save(any(Order.class));
    }

    @Test
    void testCreateOrder_InsufficientInventory() {
        Product product = new Product();
        product.setId(1L);
        product.setInventory(1);
        
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        OrderDto orderDto = new OrderDto();
        orderDto.setProductId(1L);
        orderDto.setQuantity(2);

        assertThrows(InsufficientInventoryException.class, () -> orderService.createOrder(orderDto));
    }

    @Test
    void testCreateOrder_ProductNotFound() {
        OrderDto orderDto = new OrderDto();
        orderDto.setProductId(1L);
        orderDto.setQuantity(2);

        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> orderService.createOrder(orderDto));
    }
}