package com.hugotrindade.carrinho;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hugotrindade.carrinho.domain.Categoria;
import com.hugotrindade.carrinho.domain.Produto;
import com.hugotrindade.carrinho.repositories.CategoriaRepository;
import com.hugotrindade.carrinho.repositories.ProdutoRepository;

@SpringBootApplication
public class CarrinhoDeComprasApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CarrinhoDeComprasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2.000);
		Produto p2 = new Produto(null, "Impressora", 800.0);
		Produto p3 = new Produto(null, "Mouse", 80.0);
		
		c1.addProdutos(p1, p2, p3);
		c2.addProdutos(p2);
		
		p1.addCategorias(c1);
		p2.addCategorias(c1,c2);
		p3.addCategorias(c1);
		
		categoriaRepository.saveAll(Arrays.asList(c1, c2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}
}
