package com.hugotrindade.carrinho;

import java.text.SimpleDateFormat;
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
import com.hugotrindade.carrinho.domain.ItemPedido;
import com.hugotrindade.carrinho.domain.Pagamento;
import com.hugotrindade.carrinho.domain.PagamentoComBoleto;
import com.hugotrindade.carrinho.domain.PagamentoComCartao;
import com.hugotrindade.carrinho.domain.Pedido;
import com.hugotrindade.carrinho.domain.Produto;
import com.hugotrindade.carrinho.domain.enums.EstadoPagamento;
import com.hugotrindade.carrinho.domain.enums.TipoCliente;
import com.hugotrindade.carrinho.repositories.CategoriaRepository;
import com.hugotrindade.carrinho.repositories.CidadeRepository;
import com.hugotrindade.carrinho.repositories.ClienteRepository;
import com.hugotrindade.carrinho.repositories.EnderecoRepository;
import com.hugotrindade.carrinho.repositories.EstadoRepository;
import com.hugotrindade.carrinho.repositories.ItemPedidoRepository;
import com.hugotrindade.carrinho.repositories.PagamentoRepository;
import com.hugotrindade.carrinho.repositories.PedidoRepository;
import com.hugotrindade.carrinho.repositories.ProdutoRepository;

@SpringBootApplication
public class CarrinhoDeComprasApplication implements CommandLineRunner{

	
	public static void main(String[] args) {
		SpringApplication.run(CarrinhoDeComprasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
	}
}
