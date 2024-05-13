package com.telstra.codechallenge.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URISyntaxException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(URISyntaxException.class)
    public ResponseEntity<String> handleURISyntaxException(URISyntaxException e) {
        return new ResponseEntity<>("GlobalExceptionHandler: URI syntax error." + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>("GlobalExceptionHandler: Illegal argument error." + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleOtherException(Exception e) {
        return new ResponseEntity<>("GlobalExceptionHandler: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
