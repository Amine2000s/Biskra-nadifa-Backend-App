package com.chabiamin.restapidatabase.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmsRequest {

    private final String PhoneNumber ;
    private final String Message ;


    public SmsRequest(@JsonProperty("phoneNumber") String phoneNumber,@JsonProperty("message") String message) {
        PhoneNumber = phoneNumber;
        Message = message;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getMessage() {
        return Message;
    }


    @Override
    public String toString() {
        return "SmsRequest{" +
                "PhoneNumber='" + PhoneNumber + '\'' +
                ", Message='" + Message + '\'' +
                '}';
    }
}
