package com.stackroute.userDTO;


import com.stackroute.model.UserType;

public class UserDTO {
    public String userEmail;
    public String userPassword;

    private UserType userType;

    public UserDTO() {
    }

    public UserDTO(String userEmail, String userPassword, UserType userType) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
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

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserType getUserType() {
        return userType;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userType=" + userType +
                '}';
    }
}
