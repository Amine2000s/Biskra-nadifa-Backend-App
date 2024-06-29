package com.chabiamin.restapidatabase.exception.ReportExceptions;

public class ReportNotFoundException extends RuntimeException{

    public ReportNotFoundException(String message) {
        super(message);
    }

    public ReportNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
