package com.teste.cinema.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.cinema.model.Sessao;
import com.teste.cinema.service.SessaoService;

@RestController
@RequestMapping("/sessoes")
public class SessaoController {
    
    private SessaoService sessaoService;

    public SessaoController(SessaoService sessaoService){
        this.sessaoService = sessaoService;
    }

    @GetMapping
    public List<Sessao> listarSessao(){
        return sessaoService.listarSessaos();
    }

    @PostMapping
    public Sessao  criarSessao(@RequestBody Sessao sessao){
        return sessaoService.salvarSessao(sessao);
    }
}
