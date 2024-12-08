package com.stackroute.bookingservice.controller;

import com.stackroute.bookingservice.exceptions.*;
import com.stackroute.bookingservice.model.Booking;
import com.stackroute.bookingservice.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/booking")
//@CrossOrigin(origins = "*")
public class BookingController {
    @Autowired
    public BookingService bookingService;
    public ResponseEntity<?> responseEntity;

//    @PreAuthorize("hasRole('ROLE_Owner')")
    @GetMapping("/bookingwelcome")
    public String getBlog(){return "Welcome to Bookings!";}


    @GetMapping("/bookingList")
    public ResponseEntity<?> getAllBooking() {
        try {
            List<Booking> bookings = bookingService.getAllBookingFromRepo();
            responseEntity = new ResponseEntity<>(bookings, HttpStatus.OK);
        } catch (EmptyBookingList e) {
            responseEntity = new ResponseEntity<>("Booking List is Empty", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PostMapping("/addbooking")
    public ResponseEntity<?> addBooking(@RequestBody Booking booking){
        try{
            Booking bookings= bookingService.addAllBookingToBookingdb(booking);
            responseEntity=new ResponseEntity<>(bookings,HttpStatus.CREATED);
        }catch(BookingAlreadyFound e){
            responseEntity=new ResponseEntity<>("Booking already found",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @GetMapping("/getbooking/{bookingId}")
    public ResponseEntity<?> getBookingI(@PathVariable("bookingId") String bookingId){
        try {
            Booking gbooking = bookingService.getBookingById(bookingId);
            responseEntity = new ResponseEntity<>(gbooking, HttpStatus.ACCEPTED);
        }catch (BookingIdNotFound e){
            responseEntity=new ResponseEntity<>("Booking not found",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    @GetMapping("/getplemail/{playerEmail}")
    public ResponseEntity<?> getBookingE(@PathVariable("playerEmail") String playerEmail){
        try {
         List<Booking> gbooking = bookingService.getBookingByPlayerEmail(playerEmail);
            responseEntity = new ResponseEntity<>(gbooking, HttpStatus.ACCEPTED);
        }catch (BookingPlayerEmailNotFound e){
            responseEntity=new ResponseEntity<>("Booking not found",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @GetMapping("/getgoemail/{groundOwnerEmail}")
    public ResponseEntity<?> getBookingOE(@PathVariable("groundOwnerEmail") String groundOwnerEmail){
        try {
            List<Booking> gbooking = bookingService.getBookingByOwnerEmail(groundOwnerEmail);
            responseEntity = new ResponseEntity<>(gbooking, HttpStatus.ACCEPTED);
        }catch (BookingOwnerEmailNotFound e){
            responseEntity=new ResponseEntity<>("Booking not found",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }



    @DeleteMapping("/delete/{bookingId}")
    public ResponseEntity<?> deleteBlog(@PathVariable("bookingId") String bookingId){
        try {
            Booking dbooking = bookingService.deleteBookingById(bookingId);
            responseEntity = new ResponseEntity<>(dbooking, HttpStatus.ACCEPTED);
        }catch (DeleteBookingIdNotFound e){
            responseEntity=new ResponseEntity<>("Booking to be deleted not found",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }


}
