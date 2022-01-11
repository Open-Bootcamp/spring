package com.example.barbershop.service.impl;

import com.example.barbershop.entities.Customer;
import com.example.barbershop.repository.AppointmentRepository;
import com.example.barbershop.repository.CustomerRepository;
import com.example.barbershop.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        if (id == null || id <= 0)
            return Optional.empty();

        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        if(customer == null || !StringUtils.hasLength(customer.getEmail()))
            throw new IllegalArgumentException("Email de cliente incorrecto");

        return customerRepository.save(customer);
    }

    @Override
    public boolean deleteById(Long id) {
        if(id == null || !customerRepository.existsById(id))
            return false;

        customerRepository.deleteById(id);

        return true;
    }
}
