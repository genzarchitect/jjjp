package com.stackroute.bookingservice.controller;

import com.stackroute.bookingservice.exceptions.*;
import com.stackroute.bookingservice.model.Booking;
import com.stackroute.bookingservice.model.Slot;
import com.stackroute.bookingservice.services.BookingService;
import com.stackroute.bookingservice.services.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

//there should be bookslot method so when we book a slot we can call this
//how to know if the number of player is crossing the slot limit;

@RestController
@RequestMapping("/slot")
//@CrossOrigin(origins = "*")
public class SlotController {
    @Autowired
    public SlotService slotService;
    public ResponseEntity<?> responseEntity;

    @GetMapping("/slotList")
    public ResponseEntity<?> getAllSlots() {
        try {
            List<Slot> slots = slotService.getAllSlotFromRepo();
            responseEntity = new ResponseEntity<>(slots, HttpStatus.OK);
        } catch (EmptySlotList e) {
            responseEntity = new ResponseEntity<>("Slot List is Empty", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PostMapping("/slot/book/{slotId}")
    public ResponseEntity<Slot> bookSlot(@PathVariable String slotId) {
        Slot updatedSlot = slotService.bookSlot(slotId);
        return ResponseEntity.ok(updatedSlot);
    }

    @GetMapping("/ground/{groundId}/date/{date}")
    public ResponseEntity<List<Slot>> getSlotsForGroundByDate(@PathVariable String groundId, @PathVariable String date) {
        List<Slot> slots = slotService.getSlotsForGroundByDate(groundId, date);
        return ResponseEntity.ok(slots);
    }


    @PostMapping("/addslot")
    public ResponseEntity<?> addSlot(@RequestBody Slot slot) throws SlotAlreadyFound{
        try{
            Slot slots= slotService.addAllSlotTobookingdb(slot);
            responseEntity=new ResponseEntity<>(slots,HttpStatus.CREATED);
        }catch(SlotAlreadyFound e){
            responseEntity=new ResponseEntity<>("Slot already found",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    @GetMapping("/getslot/{slotId}")
    public ResponseEntity<?> getSlotI(@PathVariable("slotId") String slotId){
        try {
            Slot gslot = slotService.getSlotById(slotId);
            responseEntity = new ResponseEntity<>(gslot, HttpStatus.ACCEPTED);
        }catch (SlotIdNotFound e){
            responseEntity=new ResponseEntity<>("Slot not found",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    @GetMapping("/getslotg/{groundId}")
    public ResponseEntity<?> getSlotG(@PathVariable("groundId") String groundId){
        try {
            Slot gIslot = slotService.getSlotById(groundId);
            responseEntity = new ResponseEntity<>(gIslot, HttpStatus.ACCEPTED);
        }catch (GroundIdNotFound e){
            responseEntity=new ResponseEntity<>("Ground id not found",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @GetMapping("getslotd/{slotDate}")
    public ResponseEntity<?> getSlotD(@PathVariable("slotDate") String slotDate){
        try {
            Slot sdslot = slotService.getSlotByDate(slotDate);
            responseEntity = new ResponseEntity<>(sdslot, HttpStatus.ACCEPTED);
        }catch (SlotDateNotFound e){
            responseEntity=new ResponseEntity<>("Slot date not found",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

//    @GetMapping("/checkMeetingRoomAvailability")
//    public @ResponseBody ResponseDto checkMeetingRoomAvailability(@DateTimeFormat(pattern = "dd-M-yyyy hh:mm:ss") Date begin,
//                                                                  @DateTimeFormat(pattern = "dd-M-yyyy hh:mm:ss") Date end, @RequestParam Integer capacity) {
//        return meetingRoomServiceLocal.checkMeetingRoomAvailability(begin, end, capacity);
//    }
    @PutMapping("/update/{slotId}")
    public ResponseEntity<?> updateSlot(@PathVariable("slotId") String slotId,@RequestBody Slot slot){
        try{
            Slot uslot = slotService.updateSlotById(slotId, slot);
            responseEntity=new ResponseEntity<>(uslot,HttpStatus.ACCEPTED);
        }catch(UpdateSlotNotFound e){
            responseEntity = new ResponseEntity<>("Please Select the slot",HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

}


