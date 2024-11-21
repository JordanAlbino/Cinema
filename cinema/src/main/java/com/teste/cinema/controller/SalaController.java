package com.teste.cinema.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.cinema.model.Sala;
import com.teste.cinema.service.SalaService;

@RestController
@RequestMapping("/salas")
public class SalaController {
    
    private SalaService salaService;

    public SalaController(SalaService salaService){
        this.salaService = salaService;
    }

    @PostMapping
    public Sala criarSala(@RequestBody Sala sala){
        return salaService.salvarSala(sala);
    }

    @GetMapping
    public List<Sala> listarSalas(){
        return salaService.listarSalas();
    }
}
