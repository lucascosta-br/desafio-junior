package com.github.lucascostabr.desafio_junior.exception;

import java.time.Instant;

public record ExceptionResponse(
        Instant timestamp,
        Integer status,
        String message,
        String path
) {
}
