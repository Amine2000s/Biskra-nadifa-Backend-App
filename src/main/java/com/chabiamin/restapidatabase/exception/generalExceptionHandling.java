package com.chabiamin.restapidatabase.exception;

import com.chabiamin.restapidatabase.exception.DriverException.DriverNotFoundException;
import com.chabiamin.restapidatabase.exception.ReportExceptions.ReportImageNotUploadedException;
import com.chabiamin.restapidatabase.exception.ReportExceptions.ReportNotFoundException;
import com.chabiamin.restapidatabase.exception.TaskExceptions.TaskNotFoundException;
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

    @ExceptionHandler(value={TaskNotFoundException.class})
    public ResponseEntity<Object> TaskNotFoundExceptionHandler(TaskNotFoundException taskNotFoundException){

        ErrorResponse errorResponse = new ErrorResponse(taskNotFoundException.getMessage(),
                HttpStatus.NOT_FOUND.value());


        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(errorResponse.getStatusCode()));



    }

    @ExceptionHandler(value={ReportImageNotUploadedException.class})
    public ResponseEntity<Object> ImageNotUploaededExceptionHandler
            (ReportImageNotUploadedException reportImageNotUploadedException){

        ErrorResponse errorResponse = new ErrorResponse(reportImageNotUploadedException.getMessage(),
                HttpStatus.BAD_REQUEST.value());


        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value={ReportNotFoundException.class})
    public ResponseEntity<Object> ReportNotFoundExceptionHandler(ReportNotFoundException reportNotFoundException){
        ErrorResponse errorResponse = new ErrorResponse(reportNotFoundException.getMessage(),
                HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>( errorResponse,HttpStatus.NOT_FOUND);
    }



}
