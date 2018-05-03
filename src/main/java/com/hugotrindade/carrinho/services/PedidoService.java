package com.hugotrindade.carrinho.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hugotrindade.carrinho.domain.Pedido;
import com.hugotrindade.carrinho.repositories.PedidoRepository;
import com.hugotrindade.carrinho.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> optional = repo.findById(id);
		return optional.orElseThrow(() -> 
		new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", tipo: " + Pedido.class.getName()));
	}
}
