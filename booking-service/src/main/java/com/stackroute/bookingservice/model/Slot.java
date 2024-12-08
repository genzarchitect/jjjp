package com.stackroute.bookingservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.sql.Time;
import java.util.Date;

@Document
public class Slot {

    @Id
    private String slotId;
    private String groundId;
    private String slotDate;
    private String slotStartTiming;
    private String slotEndTiming;
    private String status; //i think there will be no status in the slot
    private int numberOfPlayers;//why number of players

    public Slot() {
    }

    public Slot(String slotId, String groundId, String slotDate, String slotStartTiming, String slotEndTiming, String status, int numberOfPlayers) {
        this.slotId = slotId;
        this.groundId = groundId;
        this.slotDate = slotDate;
        this.slotStartTiming = slotStartTiming;
        this.slotEndTiming = slotEndTiming;
        this.status = status;
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public String getGroundId() {
        return groundId;
    }

    public void setGroundId(String groundId) {
        this.groundId = groundId;
    }

    public String getSlotDate() {
        return slotDate;
    }

    public void setSlotDate(String slotDate) {
        this.slotDate = slotDate;
    }

    public String getSlotStartTiming() {
        return slotStartTiming;
    }

    public void setSlotStartTiming(String slotStartTiming) {
        this.slotStartTiming = slotStartTiming;
    }

    public String getSlotEndTiming() {
        return slotEndTiming;
    }

    public void setSlotEndTiming(String slotEndTiming) {
        this.slotEndTiming = slotEndTiming;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "slotId='" + slotId + '\'' +
                ", groundId='" + groundId + '\'' +
                ", slotDate='" + slotDate + '\'' +
                ", slotStartTiming='" + slotStartTiming + '\'' +
                ", slotEndTiming='" + slotEndTiming + '\'' +
                ", status='" + status + '\'' +
                ", numberOfPlayers=" + numberOfPlayers +
                '}';
    }
}
