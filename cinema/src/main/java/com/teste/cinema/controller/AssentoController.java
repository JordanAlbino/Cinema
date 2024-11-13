package com.teste.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.cinema.model.Assento;
import com.teste.cinema.service.AssentoService;

@RestController
@RequestMapping("/assento")
public class AssentoController {
    @Autowired
    private AssentoService assentoService;

    @PostMapping
    public Assento criarAssento(@RequestBody Assento assento){
        return assentoService.salvarAssento(assento);
    }
}
