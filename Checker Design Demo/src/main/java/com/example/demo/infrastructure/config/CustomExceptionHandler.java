package com.example.demo.infrastructure.config;

import com.example.demo.systemuser.service.checker.exception.CustomSystemUserException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

@ControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler {

    private final MessageSource messageSource;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneralException(Exception e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
    }

    @ExceptionHandler(CustomSystemUserException.class)
    public ResponseEntity<?> handleSystemUserException(CustomSystemUserException e) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                messageSource.getMessage(e.getMessage(),
                        new Object[]{objectMapper.writeValueAsString(e.getSystemUser())}, Locale.US));
    }
}
