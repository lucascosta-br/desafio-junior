package com.github.lucascostabr.desafio_junior.exception.handle;

import com.github.lucascostabr.desafio_junior.exception.AlunoNotFoundException;
import com.github.lucascostabr.desafio_junior.exception.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleAllException(Exception ex,
                                                                HttpServletRequest request) {
        ExceptionResponse response = new ExceptionResponse(
                Instant.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AlunoNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleAlunoNotFoundException(AlunoNotFoundException ex,
                                                                          HttpServletRequest request) {
        ExceptionResponse response = new ExceptionResponse(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
