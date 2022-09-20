package com.solog.exception;

import static com.solog.api.response.ApiResponse.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        return error(e);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> BindException(BindException e) {
        return error(e);
    }

    @ExceptionHandler(SologException.class)
    public ResponseEntity<?> sologException(SologException e) {
        return error(e);
    }

}
