package com.veggieshop.validator;

import com.veggieshop.dto.ProductDto;
import com.veggieshop.exception.ResourceNotFoundException;

public class ProductValidator {

    public static void validateProduct(ProductDto productDto) {
        if (productDto == null) {
            throw new ResourceNotFoundException("Product data cannot be null.");
        }
        if (productDto.getName() == null || productDto.getName().isEmpty()) {
            throw new IllegalArgumentException("Product name is required.");
        }
        if (productDto.getPrice() <= 0) {
            throw new IllegalArgumentException("Product price must be greater than zero.");
        }
        if (productDto.getInventory() < 0) {
            throw new IllegalArgumentException("Product inventory cannot be negative.");
        }
    }
}