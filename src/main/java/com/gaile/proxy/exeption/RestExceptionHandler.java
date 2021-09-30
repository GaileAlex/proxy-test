package com.gaile.proxy.exeption;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

/**
 * @author Aleksei Gaile 27-Sep-21
 */
@Slf4j
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(Exception e) throws IOException {
        log.error("rest error occurred \n " + e.getMessage(), e);
        if (System.getProperty("spring.profiles.active", "unknown").equals("prod")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiExceptionUtil.convertErrorToJSON("Internal server error"));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON)
                    .body(ApiExceptionUtil.convertErrorToJSON(e));
        }
    }

    @ExceptionHandler(BindException.class)
    protected ResponseEntity<String> handleApiError(BindException e) throws IOException {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
                .body(ApiExceptionUtil.convertErrorToJSON(e));
    }


}
