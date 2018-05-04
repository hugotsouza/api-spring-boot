package com.hugotrindade.carrinho.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hugotrindade.carrinho.domain.Cliente;
import com.hugotrindade.carrinho.dto.ClienteDTO;
import com.hugotrindade.carrinho.repositories.ClienteRepository;
import com.hugotrindade.carrinho.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> optional = repo.findById(id);
		return optional.orElseThrow(() -> 
		new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", tipo: " + Cliente.class.getName()));
	}
	

	public Cliente update(Cliente clienteNovo) {
		Cliente clienteAntigo = find(clienteNovo.getId());
		updateData(clienteAntigo, clienteNovo);
		return repo.save(clienteNovo);
	}
	

	private void updateData(Cliente clienteAntigo, Cliente clienteNovo) {
		clienteNovo.setCpfOuCnpj(clienteAntigo.getCpfOuCnpj());
		clienteNovo.setTipo(clienteAntigo.getTipo());
	}


	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public List<Cliente> findAll() {
		return repo.findAll();
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch(DataIntegrityViolationException e){
			throw new DataIntegrityViolationException("Não é possivel excluir porque há entidades relacionadas");
		}
	}
	
	public Cliente fromDTO(ClienteDTO dto) {
		return new Cliente(dto.getId(), dto.getNome(), dto.getEmail(), null, null);
	}
	
}
