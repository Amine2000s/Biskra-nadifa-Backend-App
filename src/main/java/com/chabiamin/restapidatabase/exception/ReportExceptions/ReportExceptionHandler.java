package com.chabiamin.restapidatabase.exception.ReportExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ReportExceptionHandler {

@ExceptionHandler(value={ReportImageNotUploadedException.class})
    public ResponseEntity<Object> ImageNotUploaededExceptionHandler
            (ReportImageNotUploadedException reportImageNotUploadedException){

            ReportException reportException = new ReportException(reportImageNotUploadedException.getMessage(),
                    reportImageNotUploadedException.getCause(),
                    HttpStatus.BAD_REQUEST);


            return new ResponseEntity<>(reportException,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value={ReportNotFoundException.class})
    public ResponseEntity<Object> ReportNotFoundExceptionHandler(ReportNotFoundException reportNotFoundException){
            ReportException reportException = new ReportException(reportNotFoundException.getMessage()
                    ,reportNotFoundException.getCause(),
                    HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(reportException,reportException.getHttpStatus());
    }

}
