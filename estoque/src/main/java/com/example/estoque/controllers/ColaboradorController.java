package com.example.estoque.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.estoque.models.Colaborador;
import com.example.estoque.requests.AtualizarColaborador;
import com.example.estoque.services.ColaboradorServices;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/colaborador")
class ColaboradorController {

	@Autowired
	ColaboradorServices service ; 
	

	
	@GetMapping(value = "/listarColaborador")
	public ResponseEntity<List<Colaborador>> listar(){
	return ResponseEntity.status(HttpStatus.OK).body(service.findAll()) ; 
	}
	
    @GetMapping(value = "/buscarColaboradorPorId/{id}")
    public ResponseEntity<Colaborador> buscarPorId(@PathVariable @Valid Long id){
    	return ResponseEntity.ok().body(service.buscarPorId(id)) ; 
    	
    }
	
	@PostMapping(value = "/novoColaborador")
	public ResponseEntity<Colaborador>novoColaborador(@RequestBody @Valid Colaborador colaborador,UriComponentsBuilder uriBuilder){
		Colaborador novoRegistro = service.cadastrarColaborador(colaborador) ; 
		URI uri = uriBuilder.path("/colaborador/{id}").buildAndExpand(novoRegistro.getId()).toUri();
		return ResponseEntity.created(uri).body(novoRegistro);
	}
	
	@PutMapping(value = "/atualizarColaborador/{id}")
	@Transactional
	public ResponseEntity<Colaborador>atualizarColaborador(@PathVariable Long id,@RequestBody  @Valid AtualizarColaborador atualizarColaborador){
		 Colaborador registroAtualizado = new Colaborador() ; 
		 registroAtualizado = service.atualizarColaborador (id, atualizarColaborador) ; 
		return ResponseEntity.ok(new Colaborador(atualizarColaborador));
	}
	
}
