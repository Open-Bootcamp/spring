package com.example.barbershop.service.impl;

import com.example.barbershop.entities.HairAssistance;
import com.example.barbershop.repository.HairAssistanceRepository;
import com.example.barbershop.service.HairAssistanceService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class HairAssistanceServiceImpl implements HairAssistanceService {

    private final HairAssistanceRepository hairAssistanceRepository;

    public HairAssistanceServiceImpl(HairAssistanceRepository hairAssistanceRepository) {
        this.hairAssistanceRepository = hairAssistanceRepository;
    }

    @Override
    public Optional<HairAssistance> findById(Long id) {
        if (id == null || id <= 0)
            return Optional.empty();

        return hairAssistanceRepository.findById(id);
    }

    @Override
    public List<HairAssistance> findAll() {
        return hairAssistanceRepository.findAll();
    }

    @Override
    public HairAssistance save(HairAssistance hairAssistance) {
        if(hairAssistance == null)
            throw new IllegalArgumentException("Servicio incorrecto");

        return hairAssistanceRepository.save(hairAssistance);
    }

    @Override
    public boolean deleteById(Long id) {
        if(id == null || !hairAssistanceRepository.existsById(id))
            return false;

        hairAssistanceRepository.deleteById(id);

        return true;
    }
}
