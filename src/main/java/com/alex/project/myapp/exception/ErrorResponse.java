package com.alex.project.myapp.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
    LocalDateTime timestamp,
        int status,
        String error,
        String message
) {}
