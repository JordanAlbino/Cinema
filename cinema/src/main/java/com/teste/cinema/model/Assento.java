package com.teste.cinema.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Assento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
