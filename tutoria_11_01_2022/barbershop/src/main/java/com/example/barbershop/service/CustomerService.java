package com.example.barbershop.service;

import com.example.barbershop.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Optional<Customer> findById(Long id);

    List<Customer> findAll();

    Customer save(Customer customer);

    boolean deleteById(Long id);

}
