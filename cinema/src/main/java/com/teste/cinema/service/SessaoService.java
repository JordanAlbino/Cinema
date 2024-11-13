package com.teste.cinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.cinema.model.Sessao;
import com.teste.cinema.repository.SessaoRepository;

@Service
public class SessaoService {
    @Autowired
    private SessaoRepository sessaoRepository;

    public Sessao salvarSessao(Sessao sessao){
        return sessaoRepository.save(sessao);
    }
}
