package com.example.barbershop.service;

import com.example.barbershop.entities.HairAssistance;

import java.util.List;
import java.util.Optional;

public interface HairAssistanceService {

    Optional<HairAssistance> findById(Long id);

    List<HairAssistance> findAll();

    HairAssistance save(HairAssistance hairAssistance);

    boolean deleteById(Long id);

}
