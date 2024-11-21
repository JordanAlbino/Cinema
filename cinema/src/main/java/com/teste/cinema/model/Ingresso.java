package com.teste.cinema.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Ingresso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private Double preco;

    @ManyToOne
    private Sessao sessao;

    @ManyToOne
    private Cliente cliente;

    public Ingresso(Sessao sessao, Cliente cliente, String tipo, double preco){
        this.sessao = sessao;
        this.cliente = cliente;
        this.tipo = tipo;
        this.preco = preco;
    }

    public Ingresso(){}

    public double calcularPreco(){
        return tipo.equalsIgnoreCase("Meia") ? preco * 0.5 : preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    

    
}
