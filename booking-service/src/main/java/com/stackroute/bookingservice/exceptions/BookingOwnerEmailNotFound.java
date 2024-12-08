package com.stackroute.bookingservice.exceptions;

public class BookingOwnerEmailNotFound extends RuntimeException {
    public BookingOwnerEmailNotFound(String message) {
        super(message);
    }
}