package com.solog.exception;

import org.springframework.http.HttpStatus;

public class InvalidRequestException extends SologException {

    private static final String MESSAGE = "잘못된 요청입니다.";

    public InvalidRequestException() {
        super(MESSAGE);
    }

    public InvalidRequestException(String fieldName, String message) {
        super(MESSAGE);
        addValidation(fieldName, message);
    }

    @Override
    public int errorStatus() {
        return HttpStatus.BAD_REQUEST.value();
    }

}
