package com.stackroute.bookingservice.exceptions;

public class SlotDateNotFound extends RuntimeException{
    public SlotDateNotFound(String s) {
        super(s);
    }
}