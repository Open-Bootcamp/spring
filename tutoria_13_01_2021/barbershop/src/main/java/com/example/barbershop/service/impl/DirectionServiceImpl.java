package com.example.barbershop.service.impl;

import com.example.barbershop.entities.Appointment;
import com.example.barbershop.entities.Direction;
import com.example.barbershop.repository.DirectionRepository;
import com.example.barbershop.service.AppointmentService;
import com.example.barbershop.service.DirectionService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class DirectionServiceImpl implements DirectionService {

    private final DirectionRepository directionRepository;

    private final AppointmentService appointmentService;

    public DirectionServiceImpl(DirectionRepository directionRepository,
                                AppointmentService appointmentService) {
        this.directionRepository = directionRepository;
        this.appointmentService = appointmentService;
    }

    @Override
    public Optional<Direction> findById(Long id) {
        if (id == null || id <= 0)
            return Optional.empty();

        return directionRepository.findById(id);
    }

    @Override
    public List<Direction> findAll() {
        return directionRepository.findAll();
    }

    @Override
    public Direction save(Direction direction) {
        if(direction == null)
            throw new IllegalArgumentException("Argumento Direction incorrecto");

        return directionRepository.save(direction);

    }

    @Override
    public boolean deleteById(Long id) {
        if(id == null || !directionRepository.existsById(id))
            return false;

        directionRepository.deleteById(id);

        return true;
    }
}
