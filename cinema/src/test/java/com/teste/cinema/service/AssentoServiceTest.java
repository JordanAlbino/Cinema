package com.teste.cinema.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.teste.cinema.model.Assento;
import com.teste.cinema.repository.AssentoRepository;


@ExtendWith(MockitoExtension.class)
public class AssentoServiceTest {
    
    @Mock
    private AssentoRepository assentoRepository;

    @InjectMocks
    private AssentoService assentoService;

    @Test
    void deveSalvarAssento() {
        Assento assento = new Assento();
        assento.setNumeroAssentos(1);
        assento.setAssentosDisponiveis(false);

        //Caso um retorno diferente de void 
        // when(assentoRepository.save(assento)).thenReturn(assento);
        // Assento assentoSalvo = assentoService.salvarAssento(assento);
        
        // Assertions.assertNotNull(assentoSalvo);
        // Assertions.assertEquals(1, assentoSalvo.getNumeroAssentos());
        // Assertions.assertFalse(assentoSalvo.getAssentosDisponiveis());   

        //Se tiver um retorno void
        assentoService.salvarAssento(assento);
        Mockito.verify(assentoRepository, Mockito.times(1)).save(assento);
    }
}
