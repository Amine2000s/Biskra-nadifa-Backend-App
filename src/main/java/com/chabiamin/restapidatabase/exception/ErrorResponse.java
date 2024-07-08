package com.chabiamin.restapidatabase.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private int statusCode;
    private String message;
    public ErrorResponse(String message,int statusCode)
    {
        super();
        this.message = message;
        this.statusCode = statusCode ;
    }
}
