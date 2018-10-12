package com.nisala.androidboilerplate.data.model.request;

/**
 * Created by nisala on 12,October,2018
 */
public class LoginRequest extends RequestHeader {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
