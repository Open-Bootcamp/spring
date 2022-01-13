package com.example.barbershop.service.impl;

import com.example.barbershop.entities.Appointment;
import com.example.barbershop.repository.AppointmentRepository;
import com.example.barbershop.service.AppointmentService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

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
    public List<Appointment> findAllById(List<Long> ids) {
        if(CollectionUtils.isEmpty(ids))
            return new ArrayList<>();

        return appointmentRepository.findAllById(ids);
    }

    @Override
    public List<Appointment> findAllByCustomerId(Long id) {
        if(id == null || id <= 0)
            return new ArrayList<>();

        return appointmentRepository.findAllByCustomerId(id);
    }

    @Override
    public List<Appointment> findAllByHairAssistanceId(Long id) {
        if(id == null || id <= 0)
            return new ArrayList<>();

        return appointmentRepository.findAllByHairAssistanceId(id);
    }

    @Override
    public List<Appointment> findAllByIdNotInAndCustomerId(List<Long> ids, Long id) {
        if(id == null || id <= 0)
            return new ArrayList<>();

        if(ids == null)
            ids = new ArrayList<>();

        return appointmentRepository.findAllByIdNotInAndCustomerId(ids, id);
    }


    @Override
    public List<Appointment> findAllByCustomerEmail(String customerEmail) throws IllegalArgumentException {

        if (!StringUtils.hasLength(customerEmail) && !customerEmail.contains("@"))
            throw new IllegalArgumentException("Email incorrecto");

        return appointmentRepository.findAllByCustomerEmail(customerEmail);
    }

    @Override
    public List<Appointment> findAllByEmployeeId(Long id) {
        if(id == null || id <= 0)
            return new ArrayList<>();

        return appointmentRepository.findAllByEmployeeId(id);
    }

    @Override
    public List<Appointment> findAllByEmployeeDni(String dni) {
        if (!StringUtils.hasLength(dni))
            throw new IllegalArgumentException("DNI incorrecto");

        return appointmentRepository.findAllByEmployeeDni(dni);
    }

    @Override
    public List<Appointment> findAllByPriceLessThanEqual(Double price) {
        // Between
        // if (min == null || max == null || min <= 0 || max <= 0 || min >= max)

        if (price == null || price <= 0)
            throw new IllegalArgumentException("Precio incorrecto");

        return appointmentRepository.findAllByHairAssistancePriceLessThanEqual(price);
    }

    @Override
    public double calculateBenefitsByDate(LocalDate date) {
        if (date == null)
            return 0;

        LocalDateTime min = date.atTime(0,0);
        LocalDateTime max = date.atTime(23, 59);

//        double benefits = 0;
//        for (Appointment appointment : appointments) {
//            if (appointment.getHairAssistance() == null)
//                continue;
//
//            benefits += appointment.getHairAssistance().getPrice();
//        }
//        return benefits;
        return extractBenefits(appointmentRepository.findAllByDateBetween(min, max));
    }

    @Override
    public double calculateBenefitsByMonth(int year, Month month) {

        LocalDateTime min = LocalDateTime.of(year, month, 1, 0, 0);
        LocalDateTime max = min.plusMonths(1);

        // Opción alternativa
        // LocalDateTime max = min.with(TemporalAdjusters.lastDayOfMonth()).withHour(23).withMinute(59);

        List<Appointment> appointments = appointmentRepository.findAllByDateBetween(min, max);
        return extractBenefits(appointments);
    }



    @Override
    public double calculateBenefitsByYear(int year) {
        LocalDateTime min = LocalDateTime.of(year, 1, 1, 0, 0);
        LocalDateTime max = min.plusYears(1);

        return extractBenefits(appointmentRepository.findAllByDateBetween(min, max));
    }

    @Override
    public Appointment save(Appointment appointment) {
        if(appointment == null || appointment.getDate() == null)
            throw new IllegalArgumentException("Cita incorrecta");

        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> saveAll(List<Appointment> appointments) {
        if(!CollectionUtils.isEmpty(appointments))
            return appointmentRepository.saveAll(appointments);

        return new ArrayList<>();
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


    /**
     * Extrae el precio cobrado por cada cita y los suma obteniendo así el beneficio total
     * Utiliza técnicas de programación funcional
     * @param appointments lista de citas o sesiones
     * @return beneficio total
     */
    private Double extractBenefits(List<Appointment> appointments) {
        return appointments.stream()
                .filter(a -> a.getHairAssistance() != null)
                .map(s -> s.getHairAssistance().getPrice())
                .reduce(Double::sum)
                .orElse(0d);
    }
}
