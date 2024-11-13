package com.teste.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.cinema.model.Sessao;
import com.teste.cinema.service.SessaoService;

@RestController
@RequestMapping("/sessoes")
public class SessaoController {
    @Autowired
    private SessaoService sessaoService;

    @PostMapping
    public Sessao  criarSessao(@RequestBody Sessao sessao){
        return sessaoService.salvarSessao(sessao);
    }
}
