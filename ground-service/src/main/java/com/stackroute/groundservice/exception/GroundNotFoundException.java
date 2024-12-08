package com.stackroute.groundservice.exception;

public class GroundNotFoundException extends RuntimeException{
    public GroundNotFoundException(String message){
        super(message);
    }
}
