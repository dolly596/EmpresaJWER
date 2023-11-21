package com.projetoprova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoprova.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}