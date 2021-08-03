package com.example.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler({ResponseStatusException.class})
    public ResponseEntity<Object> exceptionsHandler(Exception e)
    {
        ApiError apiError;
        List<String> errors = new ArrayList<>();
        errors.add(e.getStackTrace()[0].getClassName() + " " + e.getLocalizedMessage());
        apiError = new ApiError(e.getMessage(),errors,((ResponseStatusException)e).getStatus());

        return new ResponseEntity<>(apiError,new HttpHeaders(),apiError.getStatus());
    }
}
