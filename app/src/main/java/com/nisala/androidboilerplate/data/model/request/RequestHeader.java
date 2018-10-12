package com.nisala.androidboilerplate.data.model.request;

import java.util.UUID;

/**
 * Created by nisala on 12,October,2018
 */
public class RequestHeader {
    private String api_key = "Bearer NAUbq7RqhxYMwtDbppizZwT733YJFbCoWHYfMA5B";
    private String device_type = "ANDROID";
    private String device_push_token;
    private String token;
    private String device_id = UUID.randomUUID().toString();

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getDevice_push_token() {
        return device_push_token;
    }

    public void setDevice_push_token(String device_push_token) {
        this.device_push_token = device_push_token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }
}
