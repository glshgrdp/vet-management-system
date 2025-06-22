package com.vet.service;

import com.vet.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerById(Long id);
    Customer saveCustomer(Customer customer);
    Optional<Customer> updateCustomer(Long id, Customer updatedCustomer);  // Optional dönecek
    boolean deleteCustomer(Long id);  // boolean dönecek
}
