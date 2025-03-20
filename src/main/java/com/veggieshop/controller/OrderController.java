package com.veggieshop.controller;

import com.veggieshop.dto.OrderDto;
import com.veggieshop.exception.InsufficientInventoryException;
import com.veggieshop.exception.ResourceNotFoundException;
import com.veggieshop.model.Order;
import com.veggieshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/checkout")
    public String showCheckoutForm(Model model) {
        model.addAttribute("orderDto", new OrderDto());
        return "order/checkout";
    }

    @PostMapping("/checkout")
    public String checkout(@Valid @ModelAttribute("orderDto") OrderDto orderDto, Model model) {
        try {
            Order order = orderService.createOrder(orderDto);
            return "redirect:/orders/confirmation/" + order.getId();
        } catch (InsufficientInventoryException e) {
            model.addAttribute("error", e.getMessage());
            return "order/checkout";
        }
    }

    @GetMapping("/confirmation/{id}")
    public String orderConfirmation(@PathVariable Long id, Model model) {
        Order order = orderService.getOrderById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
        model.addAttribute("order", order);
        return "order/confirmation";
    }

    // REST API endpoints
    @PostMapping("/api")
    @ResponseBody
    public ResponseEntity<Order> createOrder(@Valid @RequestBody OrderDto orderDto) {
        try {
            Order order = orderService.createOrder(orderDto);
            return ResponseEntity.ok(order);
        } catch (InsufficientInventoryException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/api/{id}")
    @ResponseBody
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
    }

    @GetMapping("/api")
    @ResponseBody
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
}