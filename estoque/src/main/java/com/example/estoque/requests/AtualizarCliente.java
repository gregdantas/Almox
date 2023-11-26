package com.example.estoque.requests;

import com.example.estoque.models.Cliente;
import com.example.estoque.repositories.ClienteRepository;

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
public class AtualizarCliente {

	
	private Long id ; 
	@NotNull
	private String nome;
	@NotEmpty
	@NotNull
	private String franquia;
	@NotEmpty
	@NotNull
	private String localidade; 
	
	
	
	public Cliente update(Long id , ClienteRepository repo) {
		Cliente cliente =repo.getReferenceById(id); 
		cliente.setNome(this.nome);
		cliente.setFranquia(this.franquia);
		cliente.setLocalidade(localidade);
		return cliente ; 
	}
	

}
