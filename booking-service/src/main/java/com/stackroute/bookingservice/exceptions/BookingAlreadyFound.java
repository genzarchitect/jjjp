package com.stackroute.bookingservice.exceptions;

public class BookingAlreadyFound extends RuntimeException{
    public BookingAlreadyFound(String message) {
        super(message);
    }
    }
