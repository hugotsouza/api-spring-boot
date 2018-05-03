package com.hugotrindade.carrinho.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hugotrindade.carrinho.domain.Pedido;
import com.hugotrindade.carrinho.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;

	@GetMapping(value="/{id}")
	public ResponseEntity<Pedido> listar(@PathVariable Integer id) {
		
		return ResponseEntity.ok().body(service.buscar(id));
	}
}
