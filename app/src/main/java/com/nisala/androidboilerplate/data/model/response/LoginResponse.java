package com.nisala.androidboilerplate.data.model.response;

import com.nisala.androidboilerplate.data.model.User;

/**
 * Created by nisala on 12,October,2018
 */
public class LoginResponse {
    public String access_token;
    public String token_type;
    public String expires_in;
    public User data;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}
