package com.teste.cinema.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.cinema.model.Assento;
import com.teste.cinema.service.AssentoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AssentoControllerTest {
    

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AssentoService assentoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveCriarAssento() throws Exception {
        Assento assento = new Assento();
        assento.setId(1L);
        assento.setNumeroAssentos(1);
        assento.setAssentosDisponiveis(false);

        when(assentoService.salvarAssento(any(Assento.class))).thenReturn(assento);

        mockMvc.perform(post("/assento")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(assento)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.numero").value(1))
                .andExpect(jsonPath("$.ocupado").value(false));
    }
}
