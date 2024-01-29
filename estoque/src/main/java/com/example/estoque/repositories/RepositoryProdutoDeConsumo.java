package com.example.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.estoque.models.ProdutoDeConsumo;

@Repository
public interface RepositoryProdutoDeConsumo extends JpaRepository<ProdutoDeConsumo, Long> {

}
