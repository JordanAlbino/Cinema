package com.teste.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.cinema.model.Filme;

public interface FilmeRepository extends JpaRepository <Filme, Long>{
    
}
