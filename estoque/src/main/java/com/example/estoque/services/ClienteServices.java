package com.example.estoque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.estoque.exceptions.NotFoundException;
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

	public Cliente findById(Long id) {
		Cliente resp = repository.findById(id).orElseThrow(() -> new NotFoundException(" O id " + id + " não existe "));
		return resp;
	}

	public List<Cliente> deletarPorId(Long id) {
		Boolean test = repository.existsById(id);
		if (test == true) {
			repository.deleteById(id);
			List<Cliente> lista = repository.findAll();
			return lista;
		}
		return null;

	}

	public Cliente atualizar(Long id, ClienteRepository repository, AtualizarCliente atualizarRegistro) {
		Cliente registroAtualizado = new Cliente();
		List<Cliente> lista = repository.findAll();
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId().equals(atualizarRegistro.getId())) {
				return null;
			}
			registroAtualizado = repository.getReferenceById(id);
			registroAtualizado.setId(atualizarRegistro.getId());
			registroAtualizado.setNome(atualizarRegistro.getNome());
			registroAtualizado.setFranquia(atualizarRegistro.getFranquia());
			registroAtualizado.setLocalidade(atualizarRegistro.getLocalidade());
		}
		return registroAtualizado;

		/* CORRIGIR RETORNO */
	}

	public Cliente atualizarUm(Long id, ClienteRepository repository, AtualizarCliente atualizarRegistro) {
		Cliente registroAtualizado = repository.getReferenceById(id);
		registroAtualizado.update(atualizarRegistro);
		return registroAtualizado;
	}

}
