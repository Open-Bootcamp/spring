package com.example.barbershop.controller;

import com.example.barbershop.entities.Employee;
import com.example.barbershop.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id){
        Optional<Employee> employeeOpt = employeeService.findById(id);
        if(employeeOpt.isPresent())
            return ResponseEntity.ok(employeeOpt.get());

        return ResponseEntity.notFound().build(); // 404
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        if (employee.getId() != null)
            return ResponseEntity.badRequest().build(); // 400

        return ResponseEntity.ok(employeeService.save(employee));
    }

    /**
     * Actualizar una cita existente
     * PUT http://localhost:8081/api/employees
     */
    @PutMapping("/employees")
    public ResponseEntity<Employee> update(@RequestBody Employee employee){
        if (employee.getId() == null)
            return ResponseEntity.badRequest().build(); // 400

        return ResponseEntity.ok(employeeService.save(employee));
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        boolean result = employeeService.deleteById(id);
        if(result)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.internalServerError().build();
    }

}
