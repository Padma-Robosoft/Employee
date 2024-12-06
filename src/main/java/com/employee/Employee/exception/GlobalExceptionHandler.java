package com.employee.Employee.exception;

import com.employee.Employee.dto.APIResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<APIResponseDTO<Object>> handleCustomException(CustomException exception) {
        APIResponseDTO<Object> errorResponse = new APIResponseDTO<>(
                -1,
                1001,
                exception.getMessage(),
                null
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponseDTO<Object>> handleGlobalException(Exception exception) {
        APIResponseDTO<Object> errorResponse = new APIResponseDTO<>(
                -1,
                1000,
                "An error occurred: " + exception.getMessage(),
                null
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
