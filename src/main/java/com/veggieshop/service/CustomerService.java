package com.veggieshop.service;

import com.veggieshop.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Long customerId, Customer customer);
    void deleteCustomer(Long customerId);
    Customer getCustomerById(Long customerId);
    List<Customer> getAllCustomers();
}