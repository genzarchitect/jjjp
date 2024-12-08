package com.stackroute.Exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String userAlreadyExist) {
        super(userAlreadyExist);
    }
}