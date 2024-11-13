package com.teste.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.teste.cinema.model.Cliente;
import com.teste.cinema.repository.ClienteRepository;

@SpringBootApplication
public class CinemaApplication {

	@Autowired
	private ClienteRepository clienteRepository;

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
	public CommandLineRunner run(){
		return args ->{
	 		Cliente cliente = new Cliente();
	 		cliente.setNome("João Basto");
	 		cliente.setIdade(25);
	 		clienteRepository.save(cliente);

	 		System.out.println("Cliente salvo com sucesso" + cliente);
	 	};
	}
	

}
