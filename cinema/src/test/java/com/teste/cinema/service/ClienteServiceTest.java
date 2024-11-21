package com.teste.cinema.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.teste.cinema.model.Cliente;
import com.teste.cinema.repository.ClienteRepository;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    void deveSalvarClienteComSucesso() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("João Silva");
        cliente.setIdade(30);

        Mockito.when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        Cliente clienteSalvo = clienteService.salvarCliente(cliente);

        assertNotNull(clienteSalvo);
        assertEquals(1L, clienteSalvo.getId());
        assertEquals("João Silva", clienteSalvo.getNome());
        assertEquals(30, clienteSalvo.getIdade());

        Mockito.verify(clienteRepository).save(cliente);
    }
}
