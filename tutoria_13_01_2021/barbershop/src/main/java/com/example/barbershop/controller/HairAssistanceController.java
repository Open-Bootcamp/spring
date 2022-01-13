package com.example.barbershop.controller;

import com.example.barbershop.entities.HairAssistance;
import com.example.barbershop.service.HairAssistanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HairAssistanceController {

    private final HairAssistanceService hairAssistanceService;

    public HairAssistanceController(HairAssistanceService hairAssistanceService) {
        this.hairAssistanceService = hairAssistanceService;
    }

    @GetMapping("/hair-assistances")
    public List<HairAssistance> findAll(){
        return hairAssistanceService.findAll();
    }

    @GetMapping("/hair-assistances/{id}")
    public ResponseEntity<HairAssistance> findById(@PathVariable Long id){
        Optional<HairAssistance> hairAssistanceOpt = hairAssistanceService.findById(id);
        return hairAssistanceOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping("/hair-assistances")
    public ResponseEntity<HairAssistance> create(@RequestBody HairAssistance hairAssistance){
        if (hairAssistance.getId() != null)
            return ResponseEntity.badRequest().build(); // 400

        return ResponseEntity.ok(hairAssistanceService.save(hairAssistance));
    }

    /**
     * Actualizar una cita existente
     * PUT http://localhost:8081/api/hair-assistances
     */
    @PutMapping("/hair-assistances")
    public ResponseEntity<HairAssistance> update(@RequestBody HairAssistance hairAssistance){
        if (hairAssistance.getId() == null)
            return ResponseEntity.badRequest().build(); // 400

        return ResponseEntity.ok(hairAssistanceService.save(hairAssistance));
    }

    @DeleteMapping("/hair-assistances/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        boolean result = hairAssistanceService.deleteById(id);
        if(result)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.internalServerError().build();
    }

}
