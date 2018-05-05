package com.hugotrindade.carrinho.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hugotrindade.carrinho.domain.Categoria;
import com.hugotrindade.carrinho.domain.Produto;
import com.hugotrindade.carrinho.repositories.CategoriaRepository;
import com.hugotrindade.carrinho.repositories.ProdutoRepository;
import com.hugotrindade.carrinho.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Produto buscar(Integer id) {
		Optional<Produto> optional = repo.findById(id);
		return optional.orElseThrow(() -> 
		new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", tipo: " + Produto.class.getName()));
	}
	
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
	//	return repo.search(nome, categorias, pageRequest);
}

	public Produto find(Integer id) {
		Optional<Produto> optional = repo.findById(id);
		return optional.orElseThrow(() -> 
		new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", tipo: " + Produto.class.getName()));
	}
}
