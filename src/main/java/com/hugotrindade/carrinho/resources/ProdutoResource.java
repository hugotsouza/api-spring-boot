package com.hugotrindade.carrinho.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hugotrindade.carrinho.domain.Produto;
import com.hugotrindade.carrinho.dto.ProdutoDTO;
import com.hugotrindade.carrinho.resources.utils.URL;
import com.hugotrindade.carrinho.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;

	@GetMapping(value="/{id}")
	public ResponseEntity<Produto> listar(@PathVariable Integer id) {
		
		return ResponseEntity.ok().body(service.buscar(id));
	}
	
	@GetMapping
	public ResponseEntity<Page<ProdutoDTO>> findPage(
			@RequestParam(value="nome", defaultValue="")String nome, 
			@RequestParam(value="categorias", defaultValue="")String categorias, 
			@RequestParam(value="page", defaultValue="0")Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="20")Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome")String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC")String direction) {
		
		String nomeDecoded = URL.decodeParam(nome);
		List<Integer> ids = URL.decodeIntList(categorias);
		
		Page<Produto> produtos = service.search(nomeDecoded,ids, page, linesPerPage, orderBy, direction);
		Page<ProdutoDTO> produtosDto = produtos.map(c -> new ProdutoDTO(c));
		return ResponseEntity.ok().body(produtosDto);
	}
}
