
package com.stackroute.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document

public class User {

    private String userName;
    private String userMobile;
    private String userGender;
    private UserType userType;
    @Id
    private String userEmail;
    private String userPassword;
    private String userLocation;

    public User() {
    }

    public User(String userName, String userMobile, String userGender, UserType userType, String userEmail, String userPassword, String userLocation) {
        this.userName = userName;
        this.userMobile = userMobile;
        this.userGender = userGender;
        this.userType = userType;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userLocation = userLocation;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    @Override
    public String toString() {
        return "Register{" +
                "userName='" + userName + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userType='" + userType + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userLocation=" + userLocation +
                '}';
    }
}


