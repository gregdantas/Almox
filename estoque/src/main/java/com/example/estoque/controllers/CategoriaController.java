package com.example.estoque.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.estoque.models.Categoria;
import com.example.estoque.repositories.CategoriaRepository;
import com.example.estoque.requests.AtualizarCategoria;
import com.example.estoque.services.CategoriaServices;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {
	@Autowired
	CategoriaServices service;
	CategoriaRepository repository;

	@PostMapping(value = "/novaCategoria")
	public ResponseEntity<Categoria> novaCategoria(@RequestBody @Valid Categoria categoria,
			UriComponentsBuilder uriBuilder) {
		Categoria novoRegistro = service.novaCategoria(categoria);
		URI uri = uriBuilder.path("/categoria/{id}").buildAndExpand(novoRegistro.getId()).toUri();
		return ResponseEntity.created(uri).body(novoRegistro);

	}

	@GetMapping(value = "ListarCategorias")
	public ResponseEntity<List<Categoria>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getCategorias());

	}

	@GetMapping(value = "burcarId/{id}")
	public ResponseEntity<Categoria> buscarPorId(@PathVariable @Valid Long id) {
		return ResponseEntity.ok().body(service.findById(id));

	}

	@DeleteMapping(value = "deletar/{id}")
	public ResponseEntity<Categoria> deletar(@PathVariable Long id) {
		Categoria categoria = service.deletarCategoriaPorId(id);
		return ResponseEntity.ok().body(categoria);
	}

	@PutMapping(value = "atualizarCategoria/{id}")
	@Transactional
	public ResponseEntity<Categoria> atualizar(@PathVariable Long id,@RequestBody @Valid AtualizarCategoria atualizarCategoria) {
		Categoria registroAtualizado = new Categoria();
		registroAtualizado = service.atualizarPorId(id,atualizarCategoria);
		return ResponseEntity.ok(new Categoria(registroAtualizado));

	}

	
	

}
