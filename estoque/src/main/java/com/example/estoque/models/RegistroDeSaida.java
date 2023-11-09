package com.example.estoque.models;

import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;	
import jakarta.validation.constraints.NotNull;

public class RegistroDeSaida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	@NotNull
	private Colaborador solicitante;
	@NotEmpty
	@NotNull
	private List<ProdutoDeConsumo> produto;
	@NotEmpty
	@NotNull
	private int quantidade;
	@NotEmpty
    @NotNull
    private SimpleDateFormat dataDeSaida;
	@NotEmpty
    @NotNull
	private Cliente cliente;
	@NotEmpty
    @NotNull
	private Categoria categoria ;

}
