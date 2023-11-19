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
		Cliente resp = repository.findById(id).orElseThrow(() -> new NotFoundException(" O id " + id + " não existe "));
		return resp;
	}

	public List<Cliente> deletarPorId(Long id) {
		Boolean test = repository.existsById(id);
			repository.deleteById(id);
			List<Cliente> lista = repository.findAll();
			return lista;
		 
	}

	public Cliente atualizar(Long id, ClienteRepository repository, AtualizarCliente atualizarRegistro) {
        Cliente registroAtualizado = repository.getById(id);
        registroAtualizado.setNome(atualizarRegistro.getNome());
		registroAtualizado.setFranquia(atualizarRegistro.getFranquia());
		registroAtualizado.setLocalidade(atualizarRegistro.getLocalidade());
		return registroAtualizado;
	}

}
