package com.rajesh.eventmanagement.SignUP_SignIN;

public class User {

    private String uID,name,email;

    public User(String uID, String name, String email) {
        this.uID = uID;
        this.name = name;
        this.email = email;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
