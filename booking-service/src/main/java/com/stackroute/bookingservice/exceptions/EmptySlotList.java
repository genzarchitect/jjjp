package com.stackroute.bookingservice.exceptions;

public class EmptySlotList extends RuntimeException{
    public EmptySlotList(String slotListIsEmpty) {
        super(slotListIsEmpty);
    }
}

