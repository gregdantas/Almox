package com.example.estoque.models;

import com.example.estoque.requests.AtualizarCliente;

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
import lombok.ToString;
@Entity
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "TBL_CLIENTE")


public class Cliente {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;	
	@NotEmpty
    @NotNull
    private String nome ;
	@NotEmpty
    @NotNull
    private String franquia ;
	@NotEmpty
    @NotNull
    private String localidade ;
	
		
	public Cliente(@Valid AtualizarCliente atualizaCliente) {
		this.id = atualizaCliente.getId();
		this.nome = atualizaCliente.getNome();
		this.franquia = atualizaCliente.getFranquia();
		this.localidade = atualizaCliente.getLocalidade();
	}
	
}
