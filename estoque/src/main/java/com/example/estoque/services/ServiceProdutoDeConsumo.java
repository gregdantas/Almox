package com.example.estoque.services;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.estoque.exceptions.NotFoundException;
import com.example.estoque.models.ProdutoDeConsumo;
import com.example.estoque.repositories.RepositoryProdutoDeConsumo;
import com.example.estoque.requests.AtualizarProduto;


@Service
public class ServiceProdutoDeConsumo {
	
	
	@Autowired
	RepositoryProdutoDeConsumo repository ; 
	public List<ProdutoDeConsumo>findAll(){
	return repository.findAll(); 
	}
	public ProdutoDeConsumo buscarPorId(Long id) {
		ProdutoDeConsumo produto = repository.findById(id).orElseThrow(() ->new NotFoundException(" O id " + id + " não existe "));
		return produto;
	}
	public ProdutoDeConsumo cadastrarProduto( ProdutoDeConsumo produto) {
		if(comparar(produto)==false) {
			repository.save(produto) ; 
			return produto ; 
			
		}
		return null;
	}
	private Boolean comparar(ProdutoDeConsumo produto) {
		List<ProdutoDeConsumo>lista = repository.findAll() ; 
		for(ProdutoDeConsumo i : lista)
			if(i.getNome().equals(produto.getNome())) {
				return true ; 
			}
		return false;
	}
	public ProdutoDeConsumo atualizar(Long id, AtualizarProduto atualizarProduto) {
		ProdutoDeConsumo produto = repository.findById(id).orElseThrow(() ->new NotFoundException(" O id " + id + " não existe ")) ; 
		produto.update(atualizarProduto) ; 
		return produto;
		}
	public List<ProdutoDeConsumo> deletarPorId(Long id) {
		repository.findById(id).orElseThrow(()  -> new NotFoundException(" Não foi possível deletar, " + id + " id não existe ")) ; 
		repository.deleteById(id);
		List<ProdutoDeConsumo>lista = repository.findAll() ; 
		return lista;
	}
	
	
	

}
