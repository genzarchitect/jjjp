package com.stackroute.bookingservice.exceptions;

public class SlotAlreadyFound extends RuntimeException{
    public SlotAlreadyFound(String message) {
        super(message);
    }
}
