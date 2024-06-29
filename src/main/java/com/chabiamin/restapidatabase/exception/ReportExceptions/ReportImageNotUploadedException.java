package com.chabiamin.restapidatabase.exception.ReportExceptions;

public class ReportImageNotUploadedException extends RuntimeException{
    public ReportImageNotUploadedException(String message) {
        super(message);
    }

    public ReportImageNotUploadedException(String message, Throwable cause) {
        super(message, cause);
    }
}
