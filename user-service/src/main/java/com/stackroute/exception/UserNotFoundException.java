package com.stackroute.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String noUserFound) {
        super(noUserFound);
    }
}
