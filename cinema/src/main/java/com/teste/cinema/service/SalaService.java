package com.teste.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.cinema.model.Sala;
import com.teste.cinema.repository.SalaRepository;

@Service
public class SalaService {
    @Autowired
    private SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository){
        this.salaRepository = salaRepository;
    }

    public Sala salvarSala(Sala sala){
        return salaRepository.save(sala);
    }

    public List<Sala> listarSalas(){
        return salaRepository.findAll();
    }
}
