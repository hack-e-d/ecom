package com.example.ecommerce.authentication;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {
    private String userName;
    private String password;

    public AuthenticationRequest(){

    }
    public AuthenticationRequest(String userName,String password){
       this.setUserName(userName);
       this.setPassword(password);
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
