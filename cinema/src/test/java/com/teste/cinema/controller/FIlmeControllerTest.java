package com.teste.cinema.controller;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.cinema.model.Filme;
import com.teste.cinema.service.FilmeService;

@WebMvcTest(FilmeController.class)
    class FilmeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FilmeService filmeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveCriarFilmeComSucesso() throws Exception {
        Filme filme = new Filme();
        filme.setId(1L);
        filme.setTitulo("Inception");
        filme.setGenero("Ficção Científica");

        Mockito.when(filmeService.salvarFilme(any(Filme.class))).thenReturn(filme);

        mockMvc.perform(post("/filmes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(filme))) 
                .andExpect(status().isOk()) 
                .andExpect(jsonPath("$.id").value(1L)) 
                .andExpect(jsonPath("$.titulo").value("Inception")) 
                .andExpect(jsonPath("$.genero").value("Ficção Científica")); 
    }
}
