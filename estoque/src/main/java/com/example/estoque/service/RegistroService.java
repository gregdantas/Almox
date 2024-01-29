package com.example.estoque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.estoque.exceptions.NotFoundException;
import com.example.estoque.models.Cliente;
import com.example.estoque.models.RegistroDeSaida;
import com.example.estoque.repositories.RegistroRepository;
import com.example.estoque.requests.AtualizarRegistro;

import jakarta.validation.Valid;

@Service
public class RegistroService {
	
	@Autowired
	RegistroRepository repository ; 
	public List<RegistroDeSaida> findAll() {
	return repository.findAll() ; 
	
	}
	public RegistroDeSaida findById(Long id) {
		RegistroDeSaida registro = repository.findById(id)
				.orElseThrow(()-> new NotFoundException("Registro não encontrado "+ id +" não existe"));
		return registro;
	}
	public RegistroDeSaida novoRegistro(@Valid RegistroDeSaida registroDeSaida) {
		if(comparar(registroDeSaida) == false) {
		repository.save(registroDeSaida) ; 
		return registroDeSaida ; 
		}
		return null;

	}
	private boolean comparar(RegistroDeSaida registro) {
        List<RegistroDeSaida> lista = repository.findAll() ;
        for (RegistroDeSaida i : lista)
        	if(i.getId().equals(registro.getId())) {
        		return true ; 
        	}
		return false;
	}
	public RegistroDeSaida atualizarRegistroDeSaida(Long id, AtualizarRegistro atualizarRegistro) {
		RegistroDeSaida registro = repository.findById(id).orElseThrow(() -> new NotFoundException(" O id " + id + " não existe "));
		registro = repository.getReferenceById(id);
		registro.update(atualizarRegistro);
		return registro;
		
	}
	public List<RegistroDeSaida> deletarPorId(Long id) {
		repository.findById(id).orElseThrow(()  -> new NotFoundException(" O id " + id + " não existe "));
		repository.deleteById(id);
	return repository.findAll(); 		
	}
	
}
