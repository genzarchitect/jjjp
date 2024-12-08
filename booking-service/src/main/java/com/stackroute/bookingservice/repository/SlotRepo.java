package com.stackroute.bookingservice.repository;

import com.stackroute.bookingservice.model.Booking;
import com.stackroute.bookingservice.model.Slot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface SlotRepo extends MongoRepository<Slot,Integer> {
    Optional<Slot> findBySlotDate(String slotDate);
    List<Slot> findByGroundIdAndSlotDate(String groundId, String slotDate);
    Optional<Slot> findById(int slotId);

    Slot findBySlotId(String id);

}
