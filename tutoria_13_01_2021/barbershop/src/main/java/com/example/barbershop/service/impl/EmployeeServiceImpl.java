package com.example.barbershop.service.impl;

import com.example.barbershop.entities.Appointment;
import com.example.barbershop.entities.Direction;
import com.example.barbershop.entities.Employee;
import com.example.barbershop.repository.EmployeeRepository;
import com.example.barbershop.service.AppointmentService;
import com.example.barbershop.service.DirectionService;
import com.example.barbershop.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AppointmentService appointmentService;
    private final DirectionService directionService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AppointmentService appointmentService, DirectionService directionService) {
        this.employeeRepository = employeeRepository;
        this.appointmentService = appointmentService;
        this.directionService = directionService;
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

    /**
     * Casuísticas:
     * 1. Crear un empleado sin dirección ✅
     * 2. Crear un empleado con nueva dirección sin id ✅
     * 3. Crear un empleado con direccion con id falso ✅
     * 4. Crear un empleado con dirección ya existente no ocupada ✅
     * 5. Crear un empleado con dirección ya existente pero sin los campos solo el id no ocupada ✅
     * 6. Crear un empleado con dirección ya existente sí ocupada ✅
     * @param employee
     * @return
     */
    @Override
    public Employee save(Employee employee) {
        if(employee == null || !StringUtils.hasLength(employee.getEmail()))
            throw new IllegalArgumentException("Email de empleado incorrecto");

        if (employee.getDirection() == null || employee.getDirection().getId() == null)
            return employeeRepository.save(employee);

        Optional<Direction> directionOpt = directionService.findById(employee.getDirection().getId());
        if (directionOpt.isEmpty() || employeeRepository.existsByDirectionId(employee.getDirection().getId())){
            employee.setDirection(null);
            return employeeRepository.save(employee);
        }

        Direction direction = directionOpt.get();
        direction.setStreet(StringUtils.hasLength(employee.getDirection().getStreet()) ? employee.getDirection().getStreet() : direction.getStreet());
        direction.setPostalCode(StringUtils.hasLength(employee.getDirection().getPostalCode()) ? employee.getDirection().getPostalCode() : direction.getPostalCode());
        direction.setCountry(StringUtils.hasLength(employee.getDirection().getCountry()) ? employee.getDirection().getCountry() : direction.getCountry());
        employee.setDirection(direction);
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
