package com.hugotrindade.carrinho;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hugotrindade.carrinho.domain.Categoria;
import com.hugotrindade.carrinho.repositories.CategoriaRepository;

@SpringBootApplication
public class CarrinhoDeComprasApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CarrinhoDeComprasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		
		categoriaRepository.saveAll(Arrays.asList(c1, c2));
		
	}
}
