package com.teste.cinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.cinema.model.Filme;
import com.teste.cinema.repository.FilmeRepository;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository filmeRepository;

    public Filme salvarFilme(Filme filme){
        return filmeRepository.save(filme);
    }
}
