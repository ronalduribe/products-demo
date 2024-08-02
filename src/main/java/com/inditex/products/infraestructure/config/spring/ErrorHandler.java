package com.inditex.products.infraestructure.config.spring;

import com.inditex.products.domain.exceptions.GenericException;
import com.inditex.products.domain.exceptions.NotFoundException;
import com.inditex.products.infraestructure.database.springdata.dto.ErrorEnum;
import com.products.openapi.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleInternal(final RuntimeException ex) {
        log.error(ex.getMessage());

        return getResponse(HttpStatus.OK, ErrorEnum.ERROR.getCode(),
                "Internal server error");
    }
    @ExceptionHandler(GenericException.class)
    public ResponseEntity<ErrorResponse> genericClientException(GenericException e) {
        return getResponse(HttpStatus.INTERNAL_SERVER_ERROR, ErrorEnum.ERROR, "Generic exception");
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> notFoundException(NotFoundException e) {
        return getResponse(HttpStatus.BAD_REQUEST, ErrorEnum.NOT_FOUND_PRODUCT_EXCEPTION, "");
    }

    private ResponseEntity<ErrorResponse> getResponse(HttpStatus status, ErrorEnum errorEnum) {
        return getResponse(status, errorEnum.getCode(), errorEnum.toString());
    }

    private ResponseEntity<ErrorResponse> getResponse(HttpStatus status, ErrorEnum errorEnum,
                                                    String message) {
        return getResponse(status, errorEnum.getCode(),
                errorEnum.toString() + (message.isEmpty() ? "" : " - " + message));
    }

    private ResponseEntity<ErrorResponse> getResponse(HttpStatus status, String code, String message) {
        log.error("Code {} - {}", code, message);
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.code(code);
        errorResponse.message(message);
        return ResponseEntity
                .status(status)
                .body(errorResponse);
    }
    
}
