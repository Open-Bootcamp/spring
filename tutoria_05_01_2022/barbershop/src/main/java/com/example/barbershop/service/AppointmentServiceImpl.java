package com.example.barbershop.service;

import com.example.barbershop.entities.Appointment;
import com.example.barbershop.repository.AppointmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Optional<Appointment> findById(Long id) {
        if (id == null || id <= 0)
            return Optional.empty();

        return appointmentRepository.findById(id);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> findAllByCustomerEmail(String customerEmail) throws IllegalArgumentException {

        if (!StringUtils.hasLength(customerEmail) && !customerEmail.contains("@"))
            throw new IllegalArgumentException("Email incorrecto");

        return appointmentRepository.findAllByCustomerEmail(customerEmail);
    }

    @Override
    public double calculateBenefitsByDate(LocalDate date) {
        if (date == null)
            return 0;

        LocalDateTime min = date.atTime(0,0);
        LocalDateTime max = date.atTime(23, 59);

        List<Appointment> appointments = appointmentRepository.findAllByDateBetween(min, max);

        double benefits = 0;
        for (Appointment appointment : appointments) {
            if (appointment.getHairAssistance() == null)
                continue;

            benefits += appointment.getHairAssistance().getPrice();
        }
        return benefits;

    }

    @Override
    public Appointment save(Appointment appointment) {
        if(appointment == null || appointment.getDate() == null)
            throw new IllegalArgumentException("Cita incorrecta");

        return appointmentRepository.save(appointment);
    }

    @Override
    public boolean deleteById(Long id) {
        if(id == null || !appointmentRepository.existsById(id))
            return false;

        appointmentRepository.deleteById(id);

        return true;
    }

    @Override
    public boolean deleteAll() {
        appointmentRepository.deleteAll();
        return true;
    }
}
