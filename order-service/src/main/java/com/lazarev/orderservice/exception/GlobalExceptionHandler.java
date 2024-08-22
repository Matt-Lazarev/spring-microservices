package com.lazarev.orderservice.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j //Slf4j -> logback (spring), log4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler({HttpClientErrorException.NotFound.class})
    public ResponseEntity<?> handleNotFoundException(Exception ex) {
        log.error("Resource not found: ", ex);

        Map<String, String> errors = new LinkedHashMap<>();
        errors.put("status", HttpStatus.NOT_FOUND.name());
        errors.put("message", ex.getMessage());
        errors.put("timestamp", LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errors);
    }
}