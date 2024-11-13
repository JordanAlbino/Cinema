package com.teste.cinema.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Assento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numeroAssentos;
    private Boolean assentosDisponiveis;


    public Integer getNumeroAssentos() {
        return numeroAssentos;
    }


    public void setNumeroAssentos(Integer numeroAssentos) {
        this.numeroAssentos = numeroAssentos;
    }


    public Boolean getAssentosDisponiveis() {
        return assentosDisponiveis;
    }


    public void setAssentosDisponiveis(Boolean assentosDisponiveis) {
        this.assentosDisponiveis = assentosDisponiveis;
    }

    
}
