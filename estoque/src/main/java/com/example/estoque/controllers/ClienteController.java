package com.example.estoque.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.estoque.models.Cliente;
import com.example.estoque.services.ClienteServices;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	ClienteServices service;

	@PostMapping(value = "/novoCliente")
	public Cliente novoCliente(@RequestBody Cliente cliente) {
		Cliente novoRegistro = service.novoCliente(cliente);
		return novoRegistro;

	}

	@GetMapping(value = "ListaDeClientes")
	public List<Cliente> getClientes() {
		List<Cliente> todosClientes = new ArrayList<>();
		todosClientes = service.getClientes();
		return todosClientes;
	}

}
