package com.github.lucascostabr.desafio_junior.controller;

import com.github.lucascostabr.desafio_junior.dto.AlunoRequestDTO;
import com.github.lucascostabr.desafio_junior.dto.AlunoResponseDTO;
import com.github.lucascostabr.desafio_junior.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoResponseDTO> criar(@RequestBody @Valid AlunoRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.criar(requestDTO));
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> listar() {
        return ResponseEntity.ok().body(alunoService.listar());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AlunoResponseDTO> listarPorID(@PathVariable Long id) {
        return ResponseEntity.ok().body(alunoService.listarPorID(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AlunoResponseDTO> atualizar(@PathVariable Long id,
                                                      @RequestBody @Valid AlunoRequestDTO requestDTO) {
        return ResponseEntity.ok().body(alunoService.atualizar(id, requestDTO));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunoService.deletar(id);

        return ResponseEntity.noContent().build();
    }

}
