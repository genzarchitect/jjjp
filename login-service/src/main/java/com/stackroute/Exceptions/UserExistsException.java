package com.stackroute.Exceptions;

public class UserExistsException extends RuntimeException{
    public UserExistsException(String userAlreadyExist) {
        super(userAlreadyExist);
    }


}
