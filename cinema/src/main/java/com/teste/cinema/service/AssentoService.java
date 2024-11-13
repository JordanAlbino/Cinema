package com.teste.cinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.cinema.model.Assento;
import com.teste.cinema.repository.AssentoRepository;

@Service
public class AssentoService {
    @Autowired
    private AssentoRepository assentoRepository;

    public Assento salvarAssento(Assento assento){
        return assentoRepository.save(assento);
    }
}
