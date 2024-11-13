package com.teste.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.cinema.model.Assento;

public interface  AssentoRepository extends JpaRepository<Assento, Long>{
    
}
