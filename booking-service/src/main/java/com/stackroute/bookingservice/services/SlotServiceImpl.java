package com.stackroute.bookingservice.services;

import com.stackroute.bookingservice.exceptions.*;
import com.stackroute.bookingservice.model.Booking;
import com.stackroute.bookingservice.model.Slot;
import com.stackroute.bookingservice.repository.BookingRepo;
import com.stackroute.bookingservice.repository.SlotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SlotServiceImpl implements SlotService{
    @Autowired
    public SlotRepo slotRepo;

    @Override
    public List<Slot> getAllSlotFromRepo() {
        List<Slot> slots = slotRepo.findAll();
        if (slots.size() > 0) {
            return slots;
        }
        throw new EmptySlotList("Slot List is Empty");

    }

    @Override
    public Slot addAllSlotTobookingdb(Slot slot) throws SlotAlreadyFound{
        Slot slots = slotRepo.findBySlotId(slot.getSlotId());
        if (slots!=null) {
            throw new SlotAlreadyFound("Slot is added succesfully");
        }
        return this.slotRepo.save(slot);
    }

    @Override
    public Slot getSlotById(String slotId) {
       Slot slots = slotRepo.findBySlotId(slotId);
        if (slots!=null) {
            return slots;
        }
        throw new BookingIdNotFound("slot not found");
    }
    
    @Override
    public Slot bookSlot(String slotId) {
        Slot slots = slotRepo.findBySlotId(slotId);

        if (slots!=null) {
            if (slots.getNumberOfPlayers() > 0) {
                slots.setNumberOfPlayers(slots.getNumberOfPlayers() - 1);
                return slotRepo.save(slots);
            } else {
                throw new RuntimeException("Slot is fully booked");
            }
        } else {
            throw new RuntimeException("Slot not found");
        }
    }

    @Override
    public Slot getSlotByDate(String slotDate) {
        Optional<Slot> slots = slotRepo.findBySlotDate(slotDate);
        if (slots.isPresent()) {
            Slot slot = slots.get();
            slotRepo.findBySlotDate(slotDate);
            return slot;
        }
        throw new SlotDateNotFound("slot not found");
    }


    @Override
    public List<Slot> getSlotsForGroundByDate(String groundId, String date) {
        return slotRepo.findByGroundIdAndSlotDate(groundId, date);
    }

    @Override
    public Slot updateSlotById(String slotId, Slot updatedslot) {
        Slot slots = slotRepo.findBySlotId(slotId);

        if (slots!=null) {
            slots.setSlotId(updatedslot.getSlotId());
            slots.setStatus(updatedslot.getStatus());
            slots.setSlotDate(updatedslot.getSlotDate());
            slots.setSlotStartTiming(updatedslot.getSlotStartTiming());
            slots.setSlotEndTiming(updatedslot.getSlotEndTiming());
            slots.setNumberOfPlayers(updatedslot.getNumberOfPlayers());
            slotRepo.save(slots);
            return slots;
        }
        throw new UpdateSlotNotFound("Please select the slot to update");
    }



}

