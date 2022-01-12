package com.example.barbershop.repository;

import com.example.barbershop.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByCustomerEmail(String email);

    List<Appointment> findAllByCustomerId(Long id);

    List<Appointment> findAllByDateBetween(LocalDateTime min, LocalDateTime max);

    List<Appointment> findAllByEmployeeId(Long id);

    List<Appointment> findAllByEmployeeDni(String dni);

    List<Appointment> findAllByHairAssistancePriceLessThanEqual(Double price);

    List<Appointment> findAllByIdNotInAndCustomerId(List<Long> ids, Long id);
}
