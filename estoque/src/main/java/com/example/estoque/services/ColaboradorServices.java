package com.example.estoque.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.estoque.models.Colaborador;
import com.example.estoque.repositories.ColaboradorRepository;

@Service
public class ColaboradorServices {
	
	ColaboradorRepository repository ;
	
	

	public List<Colaborador> findAll() {
		List<Colaborador>lista = repository.findAll() ; 
		return lista;
	}

}
