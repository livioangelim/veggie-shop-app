package com.veggieshop.validator;

import com.veggieshop.dto.OrderDto;
import com.veggieshop.exception.InsufficientInventoryException;
import com.veggieshop.model.Product;

import java.util.List;

public class OrderValidator {

    public void validateOrder(OrderDto orderDto, List<Product> availableProducts) {
        for (OrderItemDto item : orderDto.getItems()) {
            Product product = findProductById(item.getProductId(), availableProducts);
            if (product == null) {
                throw new ResourceNotFoundException("Product not found: " + item.getProductId());
            }
            if (item.getQuantity() > product.getInventory()) {
                throw new InsufficientInventoryException("Insufficient inventory for product: " + product.getName());
            }
        }
    }

    private Product findProductById(Long productId, List<Product> availableProducts) {
        return availableProducts.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst()
                .orElse(null);
    }
}