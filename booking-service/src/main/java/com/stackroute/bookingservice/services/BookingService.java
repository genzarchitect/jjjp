package com.stackroute.bookingservice.services;

import com.stackroute.bookingservice.model.Booking;
import com.stackroute.bookingservice.model.Slot;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    public List<Booking> getAllBookingFromRepo();

    public Booking addAllBookingToBookingdb(Booking booking);

    public Booking getBookingById(String bookingId);

    public List<Booking> getBookingByPlayerEmail(String playerEmail);
    public List<Booking> getBookingByOwnerEmail(String groundOwnerEmail);
    public Booking deleteBookingById(String bookingId);


}
