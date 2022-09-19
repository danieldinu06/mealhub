package com.danieldinu.mealhub.exception;

import org.springframework.http.HttpStatus;

public class TokenException extends RuntimeException{
    private final long serialVersionUID = 1L;

    private final String message;
    private final HttpStatus httpStatus;

    public TokenException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
