package com.example.ecommerce.Users;

import com.example.ecommerce.products.Address;

import java.util.ArrayList;

public class User {
    private String userId;
    private String userName;
    private String phoneNo;
    private String emailId;
    private ArrayList<Address> address;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public ArrayList<Address> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<Address> address) {
        this.address = address;
    }
}
