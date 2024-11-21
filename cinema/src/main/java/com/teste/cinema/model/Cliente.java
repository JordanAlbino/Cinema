package com.teste.cinema.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer idade;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Ingresso> ingressos;

    public Cliente(String nome, Integer idade){
        this.nome = nome;
        this.idade = idade;
    }

    public Cliente(){}
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString(){
        return "Cliente{" + "id=" + id +", nome='" + nome + '\'' +", idade=" + idade + '}';
    }

    
}
