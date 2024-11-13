package com.teste.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.cinema.model.Ingresso;

public interface IngressoRepository extends JpaRepository <Ingresso, Long> {
}
