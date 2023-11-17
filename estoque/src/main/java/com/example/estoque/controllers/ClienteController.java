package com.example.estoque.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.estoque.models.Cliente;
import com.example.estoque.services.ClienteServices;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	ClienteServices service;

	@PostMapping(value = "/novoCliente")
	public ResponseEntity<Cliente> novoCliente(@RequestBody Cliente cliente,UriComponentsBuilder uriBuilder) {
		Cliente novoRegistro = service.novoCliente(cliente);
		URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(novoRegistro.getId()).toUri() ; 
		return ResponseEntity.created(uri).body(novoRegistro) ; 
	}

	@GetMapping(value = "/ListaDeClientes")
	public 	ResponseEntity<List<Cliente>> getClientes() {
     return	ResponseEntity.status(HttpStatus.OK).body(service.getClientes())	 ; 
		
	
	}
	
	@GetMapping(value = "/bucarId/{id}")
	
	public ResponseEntity<Cliente> buscarId (@PathVariable Long id ) {
        return ResponseEntity.ok().body(service.finById(id));
		
	}
		 
	}
 

