package com.stackroute.groundservice.model;

import jdk.jfr.Enabled;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Ground {
    public enum Status {
        OPEN, CLOSED, UNDER_MAINTENANCE;
    }
    private String groundName;
    @Id
    private String groundId;
    private Address groundAddress;
    private String groundEquipments;
    private String groundImage;
    private String groundOwnerEmail;
    private Status status;
    private String categories;
    private String openingTime;
    private String closingTime;
    private int pricePerSlot;

    public Ground() {
    }

    public Ground(String groundName, String groundId, Address groundAddress, String groundEquipments, String groundImage, String groundOwnerEmail, Status status, String categories, String openingTime, String closingTime, int pricePerSlot) {
        this.groundName = groundName;
        this.groundId = groundId;
        this.groundAddress = groundAddress;
        this.groundEquipments = groundEquipments;
        this.groundImage = groundImage;
        this.groundOwnerEmail = groundOwnerEmail;
        this.status = status;
        this.categories = categories;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.pricePerSlot = pricePerSlot;
    }

    public String getGroundName() {
        return groundName;
    }

    public void setGroundName(String groundName) {
        this.groundName = groundName;
    }

    public String getGroundId() {
        return groundId;
    }

    public void setGroundId(String groundId) {
        this.groundId = groundId;
    }

    public Address getGroundAddress() {
        return groundAddress;
    }

    public void setGroundAddress(Address groundAddress) {
        this.groundAddress = groundAddress;
    }

    public String getGroundEquipments() {
        return groundEquipments;
    }

    public void setGroundEquipments(String groundEquipments) {
        this.groundEquipments = groundEquipments;
    }

    public String getGroundImage() {
        return groundImage;
    }

    public void setGroundImage(String groundImage) {
        this.groundImage = groundImage;
    }

    public String getGroundOwnerEmail() {
        return groundOwnerEmail;
    }

    public void setGroundOwnerEmail(String groundOwnerEmail) {
        this.groundOwnerEmail = groundOwnerEmail;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public int getPricePerSlot() {
        return pricePerSlot;
    }

    public void setPricePerSlot(int pricePerSlot) {
        this.pricePerSlot = pricePerSlot;
    }

    @Override
    public String toString() {
        return "Ground{" +
                "groundName='" + groundName + '\'' +
                ", groundId='" + groundId + '\'' +
                ", groundAddress=" + groundAddress +
                ", groundEquipments='" + groundEquipments + '\'' +
                ", groundImage='" + groundImage + '\'' +
                ", groundOwnerEmail='" + groundOwnerEmail + '\'' +
                ", status=" + status +
                ", categories='" + categories + '\'' +
                ", openingTime='" + openingTime + '\'' +
                ", closingTime='" + closingTime + '\'' +
                ", pricePerSlot=" + pricePerSlot +
                '}';
    }
}
