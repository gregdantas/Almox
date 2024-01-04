package com.example.estoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.estoque.exceptions.NotFoundException;
import com.example.estoque.models.Categoria;
import com.example.estoque.repositories.CategoriaRepository;
import com.example.estoque.requests.AtualizarCategoria;

import jakarta.validation.Valid;

@Service
public class CategoriaServices {

	@Autowired
	CategoriaRepository repository;

	public Categoria novaCategoria(Categoria categoria) {
		if (comparar(categoria) == true) {
			repository.save(categoria);
			return categoria;

		}
		return null;

	}

	private boolean comparar(Categoria categoria) {
		List<Categoria> lista = repository.findAll();
		for (int i = 0; i < lista.size(); i++)
			if (lista.get(i).getId().equals(categoria.getId())) {
				return false;
			}
		return true;
	}

	public List<Categoria> getCategorias() {
		return repository.findAll();

	}

	public Categoria findById(@Valid Long id) {
		Categoria categoria = repository.findById(id).orElseThrow(() -> new NotFoundException(" O id " + id + " não existe "));
		return categoria;
	}

	public List<Categoria> deletarCategoriaPorId(Long id) {
		repository.findById(id).orElseThrow(() -> new NotFoundException(" O id " + id + " não existe ")); 
		repository.deleteById(id);
		List<Categoria> lista = repository.findAll() ; 
        return lista ; 
	}

	public Categoria atualizarPorId(Long id, AtualizarCategoria atualizarCategoria) {
		Categoria registroAtualizado = repository.findById(id).orElseThrow(()-> new NotFoundException(" O id " + id + " não existe "));
		registroAtualizado = repository.getReferenceById(id);
		registroAtualizado.atualizar(atualizarCategoria);
		return registroAtualizado;
	}



}
