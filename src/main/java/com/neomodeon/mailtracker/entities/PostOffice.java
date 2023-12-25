package com.neomodeon.mailtracker.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PostOffice {
    @Id
    private Long id;
    private int postCode;
    private String postOfficeName;
    private String address;

    public PostOffice(int postCode, String postOfficeName, String address) {
        this.postCode = postCode;
        this.postOfficeName = postOfficeName;
        this.address = address;
    }

    public PostOffice() {

    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public String getPostOfficeName() {
        return postOfficeName;
    }

    public void setPostOfficeName(String postOfficeName) {
        this.postOfficeName = postOfficeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
