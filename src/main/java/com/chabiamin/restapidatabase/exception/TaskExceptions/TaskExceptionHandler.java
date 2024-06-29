package com.chabiamin.restapidatabase.exception.TaskExceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TaskExceptionHandler {

@ExceptionHandler(value={TaskNotFoundException.class})
    public ResponseEntity<Object> TaskNotFoundExceptionHandler(TaskNotFoundException taskNotFoundException){

        TaskException taskEX = new TaskException(taskNotFoundException.getMessage(),
                taskNotFoundException.getCause(),
                HttpStatus.BAD_REQUEST);


        return new ResponseEntity<>(taskEX,HttpStatus.NOT_FOUND);



    }






}
