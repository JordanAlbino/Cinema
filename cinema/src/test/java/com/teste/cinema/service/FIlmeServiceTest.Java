package com.teste.cinema.service;

import com.teste.cinema.model.Filme;
import com.teste.cinema.repository.FilmeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class FilmeServiceTest {

    @Mock
    private FilmeRepository filmeRepository;

    @InjectMocks
    private FilmeService filmeService;

    @Test
    void deveSalvarFilmeComSucesso() {
        Filme filme = new Filme();
        filme.setId(1L);
        filme.setTitulo("Inception");
        filme.setGenero("Ficção Científica");

        Mockito.when(filmeRepository.save(any(Filme.class))).thenReturn(filme);

        Filme filmeSalvo = filmeService.salvarFilme(filme);

        assertNotNull(filmeSalvo); 
        assertEquals(1L, filmeSalvo.getId()); 
        assertEquals("Inception", filmeSalvo.getTitulo()); 
        assertEquals("Ficção Científica", filmeSalvo.getGenero()); 

        Mockito.verify(filmeRepository).save(filme);
    }
}
