package com.veggieshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private Long customerId;

    @NotNull(message = "Product ID is required")
    private Long productId;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    private List<OrderItemDto> items = new ArrayList<>();

    // Methods to add or remove items
    public void addItem(OrderItemDto item) {
        this.items.add(item);
    }

    public void removeItem(OrderItemDto item) {
        this.items.remove(item);
    }
}