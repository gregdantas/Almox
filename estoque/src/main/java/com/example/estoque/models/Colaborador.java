package com.example.estoque.models;

import com.example.estoque.requests.AtualizarColaborador;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "Info_Colaboradores")
public class Colaborador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	@NotNull
	private String nome;
	@NotEmpty
//	@NotNull
//	private Categoria categoria ;
	@NotEmpty
    @NotNull
    private String cpf ;
	
	
	public void update(@Valid AtualizarColaborador atualizarColaborador) {
		this.id = atualizarColaborador.getId() ; 
		this.nome = atualizarColaborador.getNome();
		this.cpf = atualizarColaborador.getCpf() ; 
	}

	public Colaborador(AtualizarColaborador atualizarColaborador) {
		this.id = atualizarColaborador.getId() ; 
		this.nome = atualizarColaborador.getNome();
		this.cpf = atualizarColaborador.getCpf() ; 	}
}
