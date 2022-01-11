package com.example.barbershop.service.impl;

import com.example.barbershop.entities.Employee;
import com.example.barbershop.repository.EmployeeRepository;
import com.example.barbershop.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
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

        employeeRepository.deleteById(id);

        return true;
    }
}
