package com.teste.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.cinema.model.Sala;

public interface SalaRepository extends JpaRepository <Sala, Long> {
} 