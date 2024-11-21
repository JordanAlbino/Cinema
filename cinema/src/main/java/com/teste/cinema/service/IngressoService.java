package com.teste.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.cinema.model.Ingresso;
import com.teste.cinema.repository.IngressoRepository;

@Service
public class IngressoService {
    @Autowired
    private IngressoRepository ingressoRepository;

    public IngressoService(IngressoRepository ingressoRepository){
        this.ingressoRepository = ingressoRepository;
    }

    public Ingresso salvaIngresso(Ingresso ingresso){
        return ingressoRepository.save(ingresso);
    }

    public List<Ingresso> listaIngressos(){
        return ingressoRepository.findAll();
    }
}
