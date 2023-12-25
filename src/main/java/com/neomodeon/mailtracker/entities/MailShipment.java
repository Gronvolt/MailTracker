package com.neomodeon.mailtracker.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MailShipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mailID;
    private String receiverName;
    private String typeOfShipment;
    private int postCode;
    private String address;
    private String status;

    public MailShipment(long mailID, String receiverName, String typeOfShipment, int postCode, String address, String status) {
        this.mailID = mailID;
        this.receiverName = receiverName;
        this.typeOfShipment = typeOfShipment;
        this.postCode = postCode;
        this.address = address;
        this.status = status;
    }

    public MailShipment() {

    }

    public long getMailID() {
        return mailID;
    }

    public void setMailID(long mailID) {
        this.mailID = mailID;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getTypeOfShipment() {
        return typeOfShipment;
    }

    public void setTypeOfShipment(String typeOfShipment) {
        this.typeOfShipment = typeOfShipment;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
