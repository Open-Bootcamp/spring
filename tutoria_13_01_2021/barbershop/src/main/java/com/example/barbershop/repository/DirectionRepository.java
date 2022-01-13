package com.example.barbershop.repository;

import com.example.barbershop.entities.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectionRepository extends JpaRepository<Direction, Long> {
}
