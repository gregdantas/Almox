package com.example.estoque.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AtualizarColaborador {

	
	
	private Long id ; 
	@NotNull
	private String nome ; 
	@NotNull
	private String cpf ;  
	
	
	
	
}
