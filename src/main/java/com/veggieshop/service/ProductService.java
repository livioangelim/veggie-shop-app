package com.veggieshop.service;

import com.veggieshop.dto.ProductDto;
import com.veggieshop.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> getAllProducts();

    Optional<ProductDto> getProductById(Long id);

    ProductDto updateProduct(Long id, ProductDto productDto);

    void deleteProduct(Long id);

    List<ProductDto> findByCategory(String category);
}