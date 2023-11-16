package com.projetoprova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoprova.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}