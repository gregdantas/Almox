package com.example.estoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.estoque.exceptions.NotFoundException;
import com.example.estoque.exceptions.RegistroDuplicado;
import com.example.estoque.exceptions.StandartError;
import com.example.estoque.models.Cliente;
import com.example.estoque.repositories.ClienteRepository;
import com.example.estoque.requests.AtualizarCliente;

@Service
public class ClienteServices {

	@Autowired
	ClienteRepository repository;

	public List<Cliente> getClientes() {
		return repository.findAll();

	}


	public Cliente novoCliente(Cliente cliente) {
		if (comparar(cliente) == false) {
			repository.save(cliente);
			return cliente;
		}
		return null;
		
	}

	public Boolean comparar(Cliente cliente) {
		List<Cliente> registros = repository.findAll();
		for(Cliente i: registros)
			if (i.getNome().equals(cliente.getNome())) {
				return true;
			}
		return false;
	}

	public Cliente findById(Long id) {
		Cliente resp = repository.findById(id).orElseThrow(() -> new NotFoundException(" O id " + id + " não existe "));
		return resp;
	}

	public List<Cliente> deletarPorId(Long id) {
		repository.findById(id).orElseThrow(() -> new NotFoundException(" O id " + id + " não existe "));
		repository.deleteById(id);
		List<Cliente> lista = repository.findAll();
		return lista;

	}

	public Cliente atualizarUm(Long id, ClienteRepository repository, AtualizarCliente atualizarRegistro) {
		Cliente registro = repository.findById(id).orElseThrow(() -> new NotFoundException(" O id " + id + " não existe "));
		registro = repository.getReferenceById(id);
		registro.update(atualizarRegistro);
		return registro;
	}

}
