package com.chabiamin.restapidatabase.exception;

import com.chabiamin.restapidatabase.exception.DriverException.DriverNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class generalExceptionHandling {

    @ExceptionHandler(value = DriverNotFoundException.class)
    public ResponseEntity<Object> handleDrivernotFoundException(DriverNotFoundException driverNotFoundException){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(),driverNotFoundException.getMessage());


        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(errorResponse.getStatusCode()));
    }

}
