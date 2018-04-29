package com.hugotrindade.carrinho.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hugotrindade.carrinho.domain.Categoria;
import com.hugotrindade.carrinho.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> optional = repo.findById(id);
		return optional.orElse(null);
	}
}
