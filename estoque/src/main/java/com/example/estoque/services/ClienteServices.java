package com.example.estoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.estoque.models.Cliente;
import com.example.estoque.repositories.ClienteRepository;

@Service
public class ClienteServices {

	@Autowired
	ClienteRepository repository;

	public List<Cliente> getClientes() {
		List<Cliente> lista = repository.findAll();
		return lista;
	}

	public Cliente novoCliente(Cliente cliente) {
		if (comparar(cliente) == true) {
			repository.save(cliente);
			return cliente;
		}
		return null;

	}

	public Boolean comparar(Cliente c) {
		List<Cliente> registros = repository.findAll();
		for (int i = 0; i < registros.size(); i++)
			if (registros.get(i).getNome().equals(c.getNome())) {
				return false;
			}
		return true;	
	}

	public Cliente finById(Long id) {
		Cliente resp = repository.getReferenceById(id);
		return resp;
	}

}
