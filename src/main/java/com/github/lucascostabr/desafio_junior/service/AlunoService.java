package com.github.lucascostabr.desafio_junior.service;

import com.github.lucascostabr.desafio_junior.dto.AlunoRequestDTO;
import com.github.lucascostabr.desafio_junior.dto.AlunoResponseDTO;
import com.github.lucascostabr.desafio_junior.exception.AlunoNotFoundException;
import com.github.lucascostabr.desafio_junior.mapper.AlunoMapper;
import com.github.lucascostabr.desafio_junior.repository.AlunoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(AlunoService.class);

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoMapper alunoMapper;

    public AlunoResponseDTO criar(AlunoRequestDTO requestDTO) {
        logger.info("Criando um Aluno");

        var entity = alunoMapper.toEntity(requestDTO);
        alunoRepository.save(entity);
        return alunoMapper.toResponse(entity);
    }

    public List<AlunoResponseDTO> listar() {
        logger.info("Listando todos os Alunos");

        var alunos = alunoRepository.findAll();
        return alunoMapper.toResponseList(alunos);
    }

    public AlunoResponseDTO listarPorID(Long id) {
        logger.info("Listando um Aluno por ID");

        return alunoRepository.findById(id)
                .map(alunoMapper::toResponse)
                .orElseThrow(() -> new AlunoNotFoundException("Aluno não encontrado!"));
    }

    public List<AlunoResponseDTO> listarPorTurma(String turma) {
        logger.info("Listando Alunos por Turma");

        var alunos = alunoRepository.findByTurma(turma);

        if (alunos.isEmpty()) {
            logger.warn("Nenhum aluno encontrado para a turma '{}'", turma);
            throw new AlunoNotFoundException("Turma não encontrada ou sem alunos cadastrados");
        }

        return alunoMapper.toResponseList(alunos);
    }

    public AlunoResponseDTO atualizar(Long id, AlunoRequestDTO requestDTO) {
        logger.info("Atualizando um Aluno");

        var alunoExistente = alunoRepository.findById(id)
                .orElseThrow(() -> new AlunoNotFoundException("Aluno não encontrado!"));

        alunoExistente.setNome(requestDTO.nome());
        alunoExistente.setIdade(requestDTO.idade());
        alunoExistente.setNomeResponsavel(requestDTO.nomeResponsavel());
        alunoExistente.setTurma(requestDTO.turma());

        alunoRepository.save(alunoExistente);
        return alunoMapper.toResponse(alunoExistente);
    }

    public void deletar(Long id) {
        logger.info("Deletando um Aluno");

        alunoRepository.findById(id)
                .orElseThrow(() -> new AlunoNotFoundException("Aluno não encontrado!"));
        alunoRepository.deleteById(id);
    }

}
