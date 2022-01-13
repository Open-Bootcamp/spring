package com.example.barbershop.service;

import com.example.barbershop.entities.Direction;

import java.util.List;
import java.util.Optional;

public interface DirectionService {

    Optional<Direction> findById(Long id);

    List<Direction> findAll();

    Direction save(Direction direction);

    boolean deleteById(Long id);

}
