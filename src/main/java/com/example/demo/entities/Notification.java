package com.example.demo.entities;

public class Notification {
    private String message;
    private String type; // Par exemple, "info", "warning", "error"

    private String senderId;

    // Constructeurs, getters et setters
    public Notification() {}

    public Notification(String message, String type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;}

    public String getSenderId(){return senderId;}
    public void setSenderId(String senderId){
        this.senderId=senderId;
    }
}
