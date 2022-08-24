package com.solog.api.response;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    /* 400 - Bad Request */
    ERROR_400_0001(BAD_REQUEST, "ERROR_400_0001", "잘못된 요청입니다."),
    ERROR_400_0002(BAD_REQUEST, "ERROR_400_0002", "Required parameter"),

    /* 500 - Internal Server Error */
    ERROR_500_0001(INTERNAL_SERVER_ERROR, "ERROR_500_0001", "서버 에러가 발생했습니다. 잠시후에 다시 시도해주세요."),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

}
