package com.example.estoque.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.example.estoque.models.Cliente;
import com.example.estoque.repositories.ClienteRepository;
import com.example.estoque.requests.AtualizarCliente;
import com.example.estoque.services.ClienteServices;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	ClienteServices service;
	@Autowired
	ClienteRepository repository;

	@PostMapping(value = "/novoCliente")
	public ResponseEntity<Cliente> novoCliente(@RequestBody @Valid Cliente cliente, UriComponentsBuilder uriBuilder) {
		Cliente novoRegistro = service.cadastrarCliente(cliente);
		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(novoRegistro.getId()).toUri();
		return ResponseEntity.created(uri).body(novoRegistro);
	}

	@GetMapping(value = "/ListaDeClientes")
	public ResponseEntity<List<Cliente>> listarClientes() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getClientes());

	}

	@GetMapping(value = "/bucarId/{id}")

	public ResponseEntity<Cliente> buscarId(@PathVariable @Valid Long id) {
		return ResponseEntity.ok().body(service.buscarClientePorId(id));

	}

	@DeleteMapping(value = "deletar/{id}")

	public ResponseEntity<List<Cliente>> deletar(@PathVariable Long id) {
		//List<Cliente> listaDeClientes = service.deletarPorId(id);
		return ResponseEntity.ok().body(service.deletarPorId(id));
	}

	@PutMapping(value = "/atualizarCliente/{id}")
	@Transactional
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarCliente atualizaCliente) {
		Cliente registroAtualizado = new Cliente();
		registroAtualizado = service.atualizarCliente(id, atualizaCliente);
		return ResponseEntity.ok(new Cliente(registroAtualizado));

	}

}
