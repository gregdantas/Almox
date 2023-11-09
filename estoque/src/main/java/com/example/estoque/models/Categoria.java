package com.example.estoque.models;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Categoria {
	
	
	  @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id ;
	  @NotNull
      @NotEmpty
      private String nome; 
	  @NotNull
      @NotEmpty
	  private Colaborador  colaboradores ;
	  @NotNull
//    @NotEmpty
	  private List<ProdutoDeConsumo> produtos;

}
