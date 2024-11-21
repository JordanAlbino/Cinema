package com.teste.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.cinema.model.Sessao;
import com.teste.cinema.repository.SessaoRepository;

@Service
public class SessaoService {
    @Autowired
    private SessaoRepository sessaoRepository;

    public SessaoService(SessaoRepository sessaoRepository){
        this.sessaoRepository = sessaoRepository;
    }

    public Sessao salvarSessao(Sessao sessao){
        return sessaoRepository.save(sessao);
    }

    public List<Sessao> listarSessaos(){
        return sessaoRepository.findAll();
    }
}
