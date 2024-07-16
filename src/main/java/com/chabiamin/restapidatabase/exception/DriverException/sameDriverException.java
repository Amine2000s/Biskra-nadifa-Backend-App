package com.chabiamin.restapidatabase.exception.DriverException;

public class sameDriverException extends RuntimeException{


        public sameDriverException(String message) {
            super(message);
        }

        public sameDriverException(String message, Throwable cause) {
            super(message, cause);
        }

}
