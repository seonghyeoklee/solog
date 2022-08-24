package com.solog.api.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Slf4j
public class ApiResponse {

    public static ResponseEntity<ApiResponseEntity<?>> success() {
        return ResponseEntity.ok().body(new ApiResponseEntity<>(HttpStatus.OK, null));
    }

    public static ResponseEntity<ApiResponseEntity<?>> success(Object data) {
        return ResponseEntity.ok().body(new ApiResponseEntity<>(HttpStatus.OK, data));
    }

    public static ResponseEntity<ApiResponseEntity<?>> error(ErrorType errorType) {
        log.error(String.format(">>> %s / %s", errorType.getCode(), errorType.getMessage()));

        if (errorType.getHttpStatus().is4xxClientError()) {
            return ResponseEntity.badRequest().body(new ApiResponseEntity<>(errorType));
        }

        return ResponseEntity.internalServerError().body(new ApiResponseEntity<>(errorType));
    }

    public static ResponseEntity<ApiResponseEntity<?>> error(MethodArgumentNotValidException e) {
        ApiResponseEntity<Object> apiResponse = new ApiResponseEntity<>(ErrorType.ERROR_400_0002);
        for (FieldError fieldError : e.getFieldErrors()) {
            apiResponse.addValidation(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.badRequest().body(apiResponse);
    }

    public static ResponseEntity<ApiResponseEntity<?>> error(BindException e) {
        ApiResponseEntity<Object> apiResponse = new ApiResponseEntity<>(ErrorType.ERROR_400_0002);
        for (FieldError fieldError : e.getFieldErrors()) {
            apiResponse.addValidation(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.badRequest().body(apiResponse);
    }

}
