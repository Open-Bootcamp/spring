package com.example.barbershop.controller;

import com.example.barbershop.dto.BenefitsDTO;
import com.example.barbershop.entities.Customer;
import com.example.barbershop.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        Optional<Customer> customerOpt = customerService.findById(id);
        if(customerOpt.isPresent())
            return ResponseEntity.ok(customerOpt.get());

        return ResponseEntity.notFound().build(); // 404
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> create(@RequestBody Customer customer){
        if (customer.getId() != null)
            return ResponseEntity.badRequest().build(); // 400

        return ResponseEntity.ok(customerService.save(customer));
    }

    /**
     * Actualizar una cita existente
     * PUT http://localhost:8081/api/customers
     */
    @PutMapping("/customers")
    public ResponseEntity<Customer> update(@RequestBody Customer customer){
        if (customer.getId() == null)
            return ResponseEntity.badRequest().build(); // 400

        return ResponseEntity.ok(customerService.save(customer));
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        boolean result = customerService.deleteById(id);
        if(result)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.internalServerError().build();
    }

}
