package com.example.estoque.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

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
	
	
	
	
	
	
	
}
