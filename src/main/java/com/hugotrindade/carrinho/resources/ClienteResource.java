package com.hugotrindade.carrinho.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hugotrindade.carrinho.domain.Cliente;
import com.hugotrindade.carrinho.dto.ClienteDTO;
import com.hugotrindade.carrinho.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;

	@GetMapping(value="/{id}")
	public ResponseEntity<Cliente> listar(@PathVariable Integer id) {
		
		return ResponseEntity.ok().body(service.find(id));
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO dto, @PathVariable Integer id) {
		
		Cliente cliente = service.fromDTO(dto);
		cliente.setId(id);
		service.update(cliente);
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {
		List<Cliente> clientes = service.findAll();
		List<ClienteDTO> clientesDto = clientes.stream().map(c -> new ClienteDTO(c)).collect(Collectors.toList());
		return ResponseEntity.ok().body(clientesDto);
	}
	
	@GetMapping(value="/page")
	public ResponseEntity<Page<ClienteDTO>> findPage(
			@RequestParam(value="page", defaultValue="0")Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="20")Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome")String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC")String direction) {
		
		Page<Cliente> clientes = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ClienteDTO> clientesDto = clientes.map(c -> new ClienteDTO(c));
		return ResponseEntity.ok().body(clientesDto);
	}
	
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
}
