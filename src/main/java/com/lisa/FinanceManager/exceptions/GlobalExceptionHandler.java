package com.lisa.FinanceManager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;


@RestControllerAdvice // Combines @ControllerAdvice and @ResponseBody; applies exception handling globally across all @RestController classes.
public class GlobalExceptionHandler {

    // Handles exceptions of type ResourceNotFoundException throughout the application.
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleNotFound(ResourceNotFoundException ex) {
        // Returns a 404 Not Found response with a structured error payload containing:
        // - timestamp: when the error occurred
        // - message: the exception message (e.g., "User not found")
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                        "timestamp", LocalDateTime.now(),
                        "message", ex.getMessage()
                )
        );
    }
}

