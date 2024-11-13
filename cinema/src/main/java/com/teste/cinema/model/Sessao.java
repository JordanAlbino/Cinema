package com.teste.cinema.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Sessao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessao;

    @ManyToOne
    @JoinColumn(name = "sala", nullable = false)
    private Sala sala;

    @ManyToOne
    @JoinColumn(name = "filme", nullable = false)
    private Filme filme;

    private LocalDate dia;
    private LocalTime horario;
    
    public Long getSessao() {
        return sessao;
    }
    public void setSessao(Long sessao) {
        this.sessao = sessao;
    }
    public Sala getSala() {
        return sala;
    }
    public void setSala(Sala sala) {
        this.sala = sala;
    }
    public Filme getFilme() {
        return filme;
    }
    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    public LocalDate getDia() {
        return dia;
    }
    public void setDia(LocalDate dia) {
        this.dia = dia;
    }
    public LocalTime getHorario() {
        return horario;
    }
    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    
}
