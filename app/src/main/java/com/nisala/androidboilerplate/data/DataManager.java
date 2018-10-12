package com.nisala.androidboilerplate.data;

import com.nisala.androidboilerplate.data.model.request.LoginRequest;
import com.nisala.androidboilerplate.data.model.response.LoginResponse;
import com.nisala.androidboilerplate.data.remote.ApiService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by nisala on 12,October,2018
 */
@Singleton
public class DataManager {

    private ApiService mApiService;

    @Inject
    public DataManager(ApiService mApiService) {
        this.mApiService = mApiService;
    }

    public Observable<LoginResponse> loginUser(String apikey, LoginRequest loginUserRequest) {
        return mApiService.loginUser(apikey, loginUserRequest)
                .map(new Function<LoginResponse, LoginResponse>() {
                    @Override
                    public LoginResponse apply(LoginResponse loginUserResponse) throws Exception {
                        return loginUserResponse;
                    }
                });
    }
}
