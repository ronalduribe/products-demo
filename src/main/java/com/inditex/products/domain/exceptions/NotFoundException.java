package com.inditex.products.domain.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotFoundException extends RuntimeException {

    private HttpStatus status;

    public NotFoundException(String message, final HttpStatus status) {
        super(message);
        this.status = status;
    }


    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}