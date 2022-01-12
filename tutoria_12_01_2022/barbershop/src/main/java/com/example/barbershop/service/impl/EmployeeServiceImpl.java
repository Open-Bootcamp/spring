package com.example.barbershop.service.impl;

import com.example.barbershop.entities.Appointment;
import com.example.barbershop.entities.Employee;
import com.example.barbershop.repository.EmployeeRepository;
import com.example.barbershop.service.AppointmentService;
import com.example.barbershop.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AppointmentService appointmentService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AppointmentService appointmentService) {
        this.employeeRepository = employeeRepository;
        this.appointmentService = appointmentService;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        if (id == null || id <= 0)
            return Optional.empty();

        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        if(employee == null || !StringUtils.hasLength(employee.getEmail()))
            throw new IllegalArgumentException("Email de empleado incorrecto");

        return employeeRepository.save(employee);
    }

    @Override
    public boolean deleteById(Long id) {
        if(id == null || !employeeRepository.existsById(id))
            return false;

        // desasociar citas antes de borrar el empleado
        List<Appointment> appointmentsToUpdate = appointmentService.findAllByEmployeeId(id);
        appointmentsToUpdate.forEach(app -> app.setEmployee(null));
        appointmentService.saveAll(appointmentsToUpdate);

        employeeRepository.deleteById(id);

        return true;
    }
}
