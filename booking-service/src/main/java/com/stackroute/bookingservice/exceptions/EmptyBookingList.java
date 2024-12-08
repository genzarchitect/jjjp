package com.stackroute.bookingservice.exceptions;

public class EmptyBookingList extends RuntimeException{
    public EmptyBookingList(String bookingListIsEmpty) {
        super(bookingListIsEmpty);
    }
    }
