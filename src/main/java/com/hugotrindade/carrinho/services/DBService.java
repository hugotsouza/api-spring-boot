package com.hugotrindade.carrinho.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
import com.hugotrindade.carrinho.domain.enums.Perfil;
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

@Service
public class DBService {

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
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void instantiateDatabase() throws ParseException {
		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		Categoria c3 = new Categoria(null, "Cama, mesa e banho");
		Categoria c4 = new Categoria(null, "Eletrônicos");
		Categoria c5 = new Categoria(null, "Jardinagem");
		Categoria c6 = new Categoria(null, "Decoração");
		Categoria c7 = new Categoria(null, "Perfumaria");

		Produto p1 = new Produto(null, "Computador", 2000.0);
		Produto p2 = new Produto(null, "Impressora", 800.0);
		Produto p3 = new Produto(null, "Mouse", 80.0);
		Produto p4 = new Produto(null, "Mesa de escritório", 300.0);
		Produto p5 = new Produto(null, "Toalha", 50.0);
		Produto p6 = new Produto(null, "Colcha", 200.0);
		Produto p7 = new Produto(null, "Tv true color", 1200.0);
		Produto p8 = new Produto(null, "Roçadeira", 800.0);
		Produto p9 = new Produto(null, "Abajour", 100.0);
		Produto p10 = new Produto(null, "Pendente", 180.0);
		Produto p11 = new Produto(null, "Shampoo", 90.0);

		Produto p12 = new Produto(null, "Produto 12", 10.00);
		Produto p13 = new Produto(null, "Produto 13", 10.00);
		Produto p14 = new Produto(null, "Produto 14", 10.00);
		Produto p15 = new Produto(null, "Produto 15", 10.00);
		Produto p16 = new Produto(null, "Produto 16", 10.00);
		Produto p17 = new Produto(null, "Produto 17", 10.00);
		Produto p18 = new Produto(null, "Produto 18", 10.00);
		Produto p19 = new Produto(null, "Produto 19", 10.00);
		Produto p20 = new Produto(null, "Produto 20", 10.00);
		Produto p21 = new Produto(null, "Produto 21", 10.00);
		Produto p22 = new Produto(null, "Produto 22", 10.00);
		Produto p23 = new Produto(null, "Produto 23", 10.00);
		Produto p24 = new Produto(null, "Produto 24", 10.00);
		Produto p25 = new Produto(null, "Produto 25", 10.00);
		Produto p26 = new Produto(null, "Produto 26", 10.00);
		Produto p27 = new Produto(null, "Produto 27", 10.00);
		Produto p28 = new Produto(null, "Produto 28", 10.00);
		Produto p29 = new Produto(null, "Produto 29", 10.00);
		Produto p30 = new Produto(null, "Produto 30", 10.00);
		Produto p31 = new Produto(null, "Produto 31", 10.00);
		Produto p32 = new Produto(null, "Produto 32", 10.00);
		Produto p33 = new Produto(null, "Produto 33", 10.00);
		Produto p34 = new Produto(null, "Produto 34", 10.00);
		Produto p35 = new Produto(null, "Produto 35", 10.00);
		Produto p36 = new Produto(null, "Produto 36", 10.00);
		Produto p37 = new Produto(null, "Produto 37", 10.00);
		Produto p38 = new Produto(null, "Produto 38", 10.00);
		Produto p39 = new Produto(null, "Produto 39", 10.00);
		Produto p40 = new Produto(null, "Produto 40", 10.00);
		Produto p41 = new Produto(null, "Produto 41", 10.00);
		Produto p42 = new Produto(null, "Produto 42", 10.00);
		Produto p43 = new Produto(null, "Produto 43", 10.00);
		Produto p44 = new Produto(null, "Produto 44", 10.00);
		Produto p45 = new Produto(null, "Produto 45", 10.00);
		Produto p46 = new Produto(null, "Produto 46", 10.00);
		Produto p47 = new Produto(null, "Produto 47", 10.00);
		Produto p48 = new Produto(null, "Produto 48", 10.00);
		Produto p49 = new Produto(null, "Produto 49", 10.00);
		Produto p50 = new Produto(null, "Produto 50", 10.00);
		
		c1.addProdutos(p12, p13, p14, p15, p16, p17, p18, p19, p20,
		p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
		p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50);
		
		p12.addCategorias( c1);
		p13.addCategorias( c1);
		p14.addCategorias( c1);
		p15.addCategorias( c1);
		p16.addCategorias( c1);
		p17.addCategorias( c1);
		p18.addCategorias( c1);
		p19.addCategorias( c1);
		p20.addCategorias( c1);
		p21.addCategorias( c1);
		p22.addCategorias( c1);
		p23.addCategorias( c1);
		p24.addCategorias( c1);
		p25.addCategorias( c1);
		p26.addCategorias( c1);
		p27.addCategorias( c1);
		p28.addCategorias( c1);
		p29.addCategorias( c1);
		p30.addCategorias( c1);
		p31.addCategorias( c1);
		p32.addCategorias( c1);
		p33.addCategorias( c1);
		p34.addCategorias( c1);
		p35.addCategorias( c1);
		p36.addCategorias( c1);
		p37.addCategorias( c1);
		p38.addCategorias( c1);
		p39.addCategorias( c1);
		p40.addCategorias( c1);
		p41.addCategorias( c1);
		p42.addCategorias( c1);
		p43.addCategorias( c1);
		p44.addCategorias( c1);
		p45.addCategorias( c1);
		p46.addCategorias( c1);
		p47.addCategorias( c1);
		p48.addCategorias( c1);
		p49.addCategorias( c1);
		p50.addCategorias( c1);	
		
		c1.addProdutos(p1, p2, p3);
		c2.addProdutos(p2, p4);
		c3.addProdutos(p5, p6);
		c4.addProdutos(p1, p2, p3, p7);
		c5.addProdutos(p8);
		c6.addProdutos(p9, p10);
		c7.addProdutos(p11);

		p1.addCategorias(c1, c4);
		p2.addCategorias(c1, c2, c4);
		p3.addCategorias(c1, c4);
		p4.addCategorias(c2);
		p5.addCategorias(c3);
		p6.addCategorias(c3);
		p7.addCategorias(c4);
		p8.addCategorias(c5);
		p9.addCategorias(c6);
		p10.addCategorias(c6);
		p11.addCategorias(c7);

		categoriaRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7));
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20,
				p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, p38,
				p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade cid1 = new Cidade(null, "Uberlândia", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);

		est1.addCidades(cid1);
		est2.addCidades(cid2, cid3);

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "hugotrindade17@gmail.com", "36378912377",
				TipoCliente.PESSOA_FISICA, encoder.encode("123"));
		cli1.addTelefones("33426527", "55327433");

		Cliente cli2 = new Cliente(null, "Ana Costa", "nelio.iftm@gmail.com", "31628382740", TipoCliente.PESSOA_FISICA,encoder.encode("123"));
		cli2.getTelefones().addAll(Arrays.asList("93883321", "34252625"));
		cli2.addPerfil(Perfil.ADMIN);

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "apto 303", "São Gonçalo", "38220834", cli1, cid1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38228837", cli1, cid2);
		Endereco e3 = new Endereco(null, "Avenida Floriano", "2106", null, "Centro", "281777012", cli2, cid2);
		
		cli1.addEnderecos(e1, e2);
		cli2.addEnderecos(e3);
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),
				null);
		ped2.setPagamento(pagto2);

		cli1.addPedidos(ped1, ped2);

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));

		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 200.0, 1, 2000.0);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.0, 2, 80.0);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.0, 1, 800.0);

		ped1.addItens(ip1, ip2);
		ped2.addItens(ip3);

		p1.addItens(ip1);
		p2.addItens(ip3);
		p3.addItens(ip2);

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

	}
}
