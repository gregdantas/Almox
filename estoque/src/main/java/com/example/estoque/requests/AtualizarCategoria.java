package com.example.estoque.requests;

import com.example.estoque.models.Categoria;
import com.example.estoque.repositories.CategoriaRepository;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AtualizarCategoria {
	
	
	private Long id ; 
	@NotEmpty
	@NotNull
	private String nome ; 
	
	
	public Categoria atualizarRegistro(Long id, CategoriaRepository repo) {
		
		
		Categoria categoria = repo.getReferenceById(id);
		
		categoria.setId(this.id);
		categoria.setNome(this.nome);
		return categoria ; 
		
	}

}
