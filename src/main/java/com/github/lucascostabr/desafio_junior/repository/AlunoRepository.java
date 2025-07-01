package com.github.lucascostabr.desafio_junior.repository;

import com.github.lucascostabr.desafio_junior.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
