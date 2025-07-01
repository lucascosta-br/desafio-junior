package com.github.lucascostabr.desafio_junior.mapper;

import com.github.lucascostabr.desafio_junior.dto.AlunoRequestDTO;
import com.github.lucascostabr.desafio_junior.dto.AlunoResponseDTO;
import com.github.lucascostabr.desafio_junior.entity.Aluno;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlunoMapper {

    public Aluno toEntity(AlunoRequestDTO requestDTO) {
        Aluno aluno = new Aluno();
        aluno.setNome(requestDTO.nome());
        aluno.setIdade(requestDTO.idade());
        aluno.setNomeResponsavel(requestDTO.nomeResponsavel());
        aluno.setTurma(requestDTO.turma());
        return aluno;
    }

    public AlunoResponseDTO toResponse(Aluno aluno) {
        return new AlunoResponseDTO(aluno.getId(), aluno.getNome(), aluno.getIdade(), aluno.getNomeResponsavel(), aluno.getTurma());
    }

    public List<AlunoResponseDTO> toResponseList(List<Aluno> alunos) {
        return alunos.stream()
                .map(this::toResponse)
                .toList();
    }

}
