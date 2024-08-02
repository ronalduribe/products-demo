package com.inditex.products.domain.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GenericException extends RuntimeException {

    private HttpStatus status;

    public GenericException(String message, final HttpStatus status) {
        super(message);
        this.status = status;
    }

    public GenericException(String message) {
        super(message);
    }

    public GenericException(String message, Throwable cause) {
        super(message, cause);
    }
}
