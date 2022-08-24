package com.solog.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public class ApiResponseEntity<T> {

    private final int status;
    private final T data;
    private final String error;
    private final String message;

    @JsonInclude(Include.NON_EMPTY)
    private final Map<String, String> validation = new HashMap<>();

    public ApiResponseEntity(HttpStatus httpStatus, T data) {
        this.status = httpStatus.value();
        this.data = data;
        this.error = null;
        this.message = null;
    }

    public ApiResponseEntity(ErrorType errorType) {
        this.status = errorType.getHttpStatus().value();
        this.data = null;
        this.error = errorType.getCode();
        this.message = errorType.getMessage();
    }

    public void addValidation(String fieldName, String errorMessage) {
        this.validation.put(fieldName, errorMessage);
    }

}
