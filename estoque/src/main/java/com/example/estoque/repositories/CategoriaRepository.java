package com.example.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.estoque.models.Categoria;
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	
	

}
