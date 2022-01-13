package com.example.barbershop.service.impl;

import com.example.barbershop.entities.Appointment;
import com.example.barbershop.entities.Customer;
import com.example.barbershop.repository.CustomerRepository;
import com.example.barbershop.service.AppointmentService;
import com.example.barbershop.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final AppointmentService appointmentService;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               AppointmentService appointmentService) {
        this.customerRepository = customerRepository;
        this.appointmentService = appointmentService;
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

        // 1. Guardar customer
        Customer customerDB = customerRepository.save(customer);

        /* 2. Actualizar appointments asociados:
        si queremos que desde el controlador /api/customers se puedan
        asociar citas a un cliente de manera efectiva entonces hay que guardar
        desde el lado owner, es decir, las citas.
         */

        List<Long> ids = customer.getAppointments().stream().map(Appointment::getId).toList();
        List<Appointment> appointments = appointmentService.findAllById(ids);
        appointments.forEach(app -> app.setCustomer(customerDB));
        customerDB.setAppointments(appointmentService.saveAll(appointments));

        // Desasociar appointments que no vienen en el update:
        List<Appointment> appointmentsToUpdate = appointmentService.findAllByIdNotInAndCustomerId(ids, customerDB.getId());
        appointmentsToUpdate.forEach(app -> app.setCustomer(null));
        appointmentService.saveAll(appointmentsToUpdate);

        return customerDB;
    }

    @Override
    public boolean deleteById(Long id) {
        if(id == null || !customerRepository.existsById(id))
            return false;

        // desasociar citas antes de borrar el cliente
        List<Appointment> appointmentsToUpdate = appointmentService.findAllByCustomerId(id);
        appointmentsToUpdate.forEach(app -> app.setCustomer(null));
        appointmentService.saveAll(appointmentsToUpdate);

        customerRepository.deleteById(id);

        return true;
    }
}
