package com.teste.cinema.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.cinema.model.Ingresso;
import com.teste.cinema.service.IngressoService;

@RestController
@RequestMapping("/ingressos")
public class IngressoController {
    private final IngressoService ingressoService;

    public IngressoController(IngressoService ingressoService){
        this.ingressoService = ingressoService;
    }

    @GetMapping
    public List<Ingresso> listaIngressos(){
        return ingressoService.listaIngressos();
    }

    @PostMapping
    public Ingresso venderIngresso(@RequestBody Ingresso ingresso){
        return ingressoService.salvaIngresso(ingresso);
    }
}
