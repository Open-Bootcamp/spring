package com.example.barbershop.service;

import com.example.barbershop.entities.Appointment;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * CRUD: Create, Retrieve / Read, Update, Delete
 */
public interface AppointmentService {

    Optional<Appointment> findById(Long id);
    List<Appointment> findAll();
    List<Appointment> findAllByCustomerEmail(String customerEmail) throws IllegalArgumentException;

    double calculateBenefitsByDate(LocalDate date);

    Appointment save(Appointment appointment);

    boolean deleteById(Long id);

    boolean deleteAll();

}
