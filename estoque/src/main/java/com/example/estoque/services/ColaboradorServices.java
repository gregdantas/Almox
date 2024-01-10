package com.example.estoque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.estoque.exceptions.NotFoundException;
import com.example.estoque.models.Colaborador;
import com.example.estoque.repositories.ColaboradorRepository;
import com.example.estoque.requests.AtualizarColaborador;

import jakarta.validation.Valid;

@Service
public class ColaboradorServices {
	@Autowired
	ColaboradorRepository repository ;
	
	

	public List<Colaborador> findAll() {
		List<Colaborador>lista = repository.findAll() ; 
		return lista;
	}
	
	
	public Colaborador buscarPorId(Long id){
		Colaborador colaboradorLocal = repository.findById(id).orElseThrow(() -> new NotFoundException(" O id " + id + " não existe "));
		return colaboradorLocal;
		
	}


	public Colaborador cadastrarColaborador(Colaborador colaborador) {
		 if(comparar(colaborador) == false) {
			repository.save(colaborador) ; 
			return colaborador ;
			
		}
		return null;
	}

	private boolean comparar(Colaborador colaborador) {
		List<Colaborador>registros = repository.findAll();
		for(Colaborador i : registros)
			if(i.getNome().equals(colaborador.getNome())) {
		return true;
	}
		return false;

	}


	public Colaborador atualizarColaborador(Long id, @Valid AtualizarColaborador atualizarColaborador) {
		Colaborador registro = repository.findById(id).orElseThrow(() -> new NotFoundException(" O id " + id + " não existe ")) ; 
		registro.update(atualizarColaborador) ; 
		return registro;
	}
}
