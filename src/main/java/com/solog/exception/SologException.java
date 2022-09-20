package com.solog.exception;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
public abstract class SologException extends RuntimeException {

    private final Map<String, String> validation;

    public SologException(String message) {
        super(message);
        this.validation = new HashMap<>();
    }

    public abstract int errorStatus();

    public void addValidation(String fieldName, String message) {
        this.validation.put(fieldName, message);
    }
}
