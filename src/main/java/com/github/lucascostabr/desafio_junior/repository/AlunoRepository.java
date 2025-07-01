package com.github.lucascostabr.desafio_junior.repository;

import com.github.lucascostabr.desafio_junior.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByTurma(String turma);
}
