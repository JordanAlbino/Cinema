package com.teste.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.cinema.model.Sessao;

public interface SessaoRepository extends JpaRepository <Sessao, Long>{
}