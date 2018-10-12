package com.nisala.androidboilerplate.login;

import com.nisala.androidboilerplate.base.MvpView;
import com.nisala.androidboilerplate.data.model.response.LoginResponse;

/**
 * Created by nisala on 12,October,2018
 */
public interface LoginMvpView extends MvpView {
    void LoginUserDetails(LoginResponse loginUserResponse);

    void showStart();

    void showEnd();

    void endError(int errorCode);
}
