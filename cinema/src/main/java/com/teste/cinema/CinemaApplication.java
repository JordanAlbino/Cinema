package com.teste.cinema;


import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.teste.cinema.model.Cliente;
import com.teste.cinema.model.Filme;
import com.teste.cinema.model.Ingresso;
import com.teste.cinema.model.Sala;
import com.teste.cinema.model.Sessao;
import com.teste.cinema.service.ClienteService;
import com.teste.cinema.service.FilmeService;
import com.teste.cinema.service.IngressoService;
import com.teste.cinema.service.SalaService;
import com.teste.cinema.service.SessaoService;


@SpringBootApplication
public class CinemaApplication {


	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
	}

	//@Bean
	// public static FlywayMigrationStrategy clearMigrationStrategy(){
	//	return flyway -> {
	//		flyway.repair();
	//		flyway.migrate();
	//	};
	//}
	
	@Bean
public CommandLineRunner run(FilmeService filmeService, SalaService salaService, SessaoService sessaoService, ClienteService clienteService,
    IngressoService ingressoService){
    return args -> {
        Filme filme = new Filme("Homem Aranha", "Filme bem divertido", 148, "Ficção Científica", "12 ANOS");
        filme = filmeService.salvarFilme(filme);
        System.out.println("Filme cadastrado: " + filme.getTitulo());

        Sala sala = new Sala(40, "3D");
        sala = salaService.salvarSala(sala);
        System.out.println("Sala cadastrada: " + sala.getTipo());

        Sessao sessao = new Sessao();
        sessao.setFilme(filme);
        sessao.setSala(sala);
        sessao.setHorario(LocalDateTime.now().plusHours(1));
        sessao.setAssentosDisponiveis(sala.getNumeroAssentos());
        sessao = sessaoService.salvarSessao(sessao);
        System.out.println("Sessão criada para o filme: " + sessao.getFilme().getTitulo());

        Cliente cliente = new Cliente("Ana Oliveira", 18);
        cliente = clienteService.salvarCliente(cliente);
        System.out.println("Cliente cadastrado: " + cliente.getNome());

        if (sessao.reservarAssentos(5)) {
            Ingresso ingresso = new Ingresso(sessao, cliente, "Meia", 50);
            ingresso = ingressoService.salvaIngresso(ingresso);
            // Sessão não precisa ser salva novamente se não houve alteração no número de assentos
            System.out.println("Ingresso vendido para o cliente: " + cliente.getNome());
            System.out.println("Preço final com desconto: " + ingresso.calcularPreco());
        } else {
            System.out.println("Não há assentos disponíveis para esta sessão.");
        }

        System.out.println("Filmes cadastrados:");
        filmeService.listarFilmes().forEach(f -> System.out.println("- " + f.getTitulo()));
    };
}
	
	

}
