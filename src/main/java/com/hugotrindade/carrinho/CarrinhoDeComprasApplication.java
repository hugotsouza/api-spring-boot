package com.hugotrindade.carrinho;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hugotrindade.carrinho.domain.Categoria;
import com.hugotrindade.carrinho.domain.Cidade;
import com.hugotrindade.carrinho.domain.Cliente;
import com.hugotrindade.carrinho.domain.Endereco;
import com.hugotrindade.carrinho.domain.Estado;
import com.hugotrindade.carrinho.domain.Produto;
import com.hugotrindade.carrinho.domain.enums.TipoCliente;
import com.hugotrindade.carrinho.repositories.CategoriaRepository;
import com.hugotrindade.carrinho.repositories.CidadeRepository;
import com.hugotrindade.carrinho.repositories.ClienteRepository;
import com.hugotrindade.carrinho.repositories.EnderecoRepository;
import com.hugotrindade.carrinho.repositories.EstadoRepository;
import com.hugotrindade.carrinho.repositories.ProdutoRepository;

@SpringBootApplication
public class CarrinhoDeComprasApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
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
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null, "Uberlândia", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);
		
		est1.addCidades(cid1);
		est2.addCidades(cid2, cid3);
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOA_FISICA);
		cli1.addTelefones("33426527","55327433");
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "apto 303", "São Gonçalo", "38220834", cli1, cid1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38228837", cli1, cid2);
		
		cli1.addEnderecos(e1, e2);
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
		
		
		
		
	}
}
