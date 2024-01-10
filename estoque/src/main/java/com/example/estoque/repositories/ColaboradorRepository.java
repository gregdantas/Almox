package com.example.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.estoque.models.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador ,Long> {

}
