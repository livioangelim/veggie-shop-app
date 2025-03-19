package com.veggieshop.service.impl;

import com.veggieshop.dto.OrderDto;
import com.veggieshop.exception.InsufficientInventoryException;
import com.veggieshop.exception.ResourceNotFoundException;
import com.veggieshop.model.Order;
import com.veggieshop.model.OrderItem;
import com.veggieshop.model.Product;
import com.veggieshop.repository.OrderRepository;
import com.veggieshop.repository.ProductRepository;
import com.veggieshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public Order createOrder(OrderDto orderDto) {
        Order order = new Order();
        List<OrderItem> orderItems = orderDto.getOrderItems();

        for (OrderItem item : orderItems) {
            Product product = productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + item.getProductId()));

            if (product.getInventory() < item.getQuantity()) {
                throw new InsufficientInventoryException("Not enough inventory for product: " + product.getName());
            }

            product.setInventory(product.getInventory() - item.getQuantity());
            order.addOrderItem(item);
        }

        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + orderId));
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}