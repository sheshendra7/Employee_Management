package com.pradaise.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
//    private String message;
//
//    public ResourceNotFoundException(String message) {
//        this.message = message;
//    }
//
//    public ResourceNotFoundException(String message, String message1) {
//        super(message);
//        this.message = message1;
//    }
//
//    public ResourceNotFoundException(String message, Throwable cause, String message1) {
//        super(message, cause);
//        this.message = message1;
//    }
//
//    public ResourceNotFoundException(Throwable cause, String message) {
//        super(cause);
//        this.message = message;
//    }
//
//    public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1) {
//        super(message, cause, enableSuppression, writableStackTrace);
//        this.message = message1;
//    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
