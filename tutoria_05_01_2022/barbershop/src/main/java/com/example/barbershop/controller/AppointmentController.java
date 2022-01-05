package com.example.barbershop.controller;

import com.example.barbershop.dto.BenefitsDTO;
import com.example.barbershop.entities.Appointment;
import com.example.barbershop.service.AppointmentService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    /**
     * GET http://localhost:8081/api/appointments
     */
    @GetMapping("/appointments")
    public List<Appointment> findAll(){
        return appointmentService.findAll();
    }

    /**
     * GET http://localhost:8081/api/appointments/1
     * GET http://localhost:8081/api/appointments/2
     */
    @GetMapping("/appointments/{id}")
    public ResponseEntity<Appointment> findById(@PathVariable Long id){

        Optional<Appointment> appointmentOpt = appointmentService.findById(id);
        if(appointmentOpt.isPresent())
            return ResponseEntity.ok(appointmentOpt.get());

        return ResponseEntity.notFound().build(); // 404

//        return appointmentService.findById(id)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Crea una nueva cita
     * POST http://localhost:8081/api/appointments
     */
    @PostMapping("/appointments")
    public ResponseEntity<Appointment> create(@RequestBody Appointment appointment){
        if (appointment.getId() != null)
            return ResponseEntity.badRequest().build(); // 400

        return ResponseEntity.ok(appointmentService.save(appointment));
    }

    /**
     * Actualizar una cita existente
     * PUT http://localhost:8081/api/appointments
     */
    @PutMapping("/appointments")
    public ResponseEntity<Appointment> update(@RequestBody Appointment appointment){
        if (appointment.getId() == null)
            return ResponseEntity.badRequest().build(); // 400

        return ResponseEntity.ok(appointmentService.save(appointment));
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        boolean result = appointmentService.deleteById(id);
        if(result)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.internalServerError().build();
    }


    @GetMapping("/appointments/benefits/{year}/{month}/{day}")
    public ResponseEntity<BenefitsDTO> benefitsDate(@PathVariable int year, @PathVariable int month, @PathVariable int day){
        double benefits = appointmentService.calculateBenefitsByDate(LocalDate.of(year, month, day));
        BenefitsDTO benefitsDTO = new BenefitsDTO(benefits);
        return ResponseEntity.ok(benefitsDTO);
    }


//    public ResponseEntity<BenefitsDTO> benefitsMonth(){}
//    public ResponseEntity<BenefitsDTO> benefitsYear(){}


}
