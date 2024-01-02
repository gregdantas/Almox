package com.example.estoque.models;

import java.util.List;

import com.example.estoque.requests.AtualizarCategoria;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Info_Categoria")
public class Categoria {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nome;
	
	/*
	 * private List<Colaborador> colaboradores ; private List<ProdutoDeConsumo>
	 * produtos ;
	 */
	
	public Categoria(Categoria registroAtualizado) {
	this.id = registroAtualizado.getId() ; 
     this.nome = registroAtualizado.getNome(); 	
	}

	public void atualizar( AtualizarCategoria atualizarCategoria) {
		this.id = (atualizarCategoria.getId()) ; 
	     this.nome = (atualizarCategoria.getNome()); 
	}
}
