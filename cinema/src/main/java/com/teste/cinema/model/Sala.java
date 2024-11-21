package com.teste.cinema.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Sala;
    private Integer numeroAssentos;
    private String tipo;

    public Sala(Integer numeroAssentos, String tipo){
        this.numeroAssentos = numeroAssentos;
        this.tipo = tipo;
    }

    public Sala(){}

    public Long getId_Sala() {
        return id_Sala;
    }

    public void setId_Sala(Long id_Sala) {
        this.id_Sala = id_Sala;
    }

    public Integer getNumeroAssentos() {
        return numeroAssentos;
    }

    public void setNumeroAssentos(Integer numeroAssentos) {
        this.numeroAssentos = numeroAssentos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
