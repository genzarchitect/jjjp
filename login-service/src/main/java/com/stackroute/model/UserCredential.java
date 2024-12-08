package com.stackroute.model;

public class UserCredential {
    private String useremail;
    private String password;

    public UserCredential() {
    }

    public UserCredential(String useremail, String password) {
        this.useremail = useremail;
        this.password = password;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserCredential{" +
                "useremail='" + useremail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

