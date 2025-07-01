package com.github.lucascostabr.desafio_junior.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlunoRequestDTO(
        @NotBlank(message = "O nome não pode estar vazio.") String nome,
        @NotNull(message = "A idade não pode está vazia.") Integer idade,
        @NotBlank(message = "O nome do responsável não pode estar vazio.") String nomeResponsavel,
        @NotBlank(message = "A turma não pode estar vazio.") String turma
) {
}
