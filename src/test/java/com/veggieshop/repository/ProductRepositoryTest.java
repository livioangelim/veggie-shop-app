package com.veggieshop.repository;

import com.veggieshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product();
        product.setName("Test Product");
        product.setPrice(BigDecimal.valueOf(10.99));
        product.setInventory(100);
    }

    @Test
    public void testSaveProduct() {
        Product savedProduct = productRepository.save(product);
        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindProductById() {
        Product savedProduct = productRepository.save(product);
        Optional<Product> foundProduct = productRepository.findById(savedProduct.getId());
        assertThat(foundProduct).isPresent();
        assertThat(foundProduct.get().getName()).isEqualTo("Test Product");
    }

    @Test
    public void testDeleteProduct() {
        Product savedProduct = productRepository.save(product);
        productRepository.delete(savedProduct);
        Optional<Product> foundProduct = productRepository.findById(savedProduct.getId());
        assertThat(foundProduct).isNotPresent();
    }

    @Test
    public void testProductNameNotNull() {
        product.setName(null);
        assertThrows(DataIntegrityViolationException.class, () -> productRepository.save(product));
    }

    @Test
    public void testProductPriceNotNull() {
        product.setPrice(null);
        assertThrows(DataIntegrityViolationException.class, () -> productRepository.save(product));
    }

    @Test
    public void testProductInventoryNotNull() {
        product.setInventory(null);
        assertThrows(DataIntegrityViolationException.class, () -> productRepository.save(product));
    }
}