package com.nisala.androidboilerplate.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.nisala.androidboilerplate.R;
import com.nisala.androidboilerplate.base.BaseActivity;
import com.nisala.androidboilerplate.data.model.request.LoginRequest;
import com.nisala.androidboilerplate.data.model.response.LoginResponse;
import com.nisala.androidboilerplate.util.AndroidBoilerplateHelper;
import com.nisala.androidboilerplate.util.AndroidBoilerplateConstant;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginMvpView {

    @Inject
    LoginPresenter mLogInPresenter;

    @BindView(R.id.et_email)
    EditText mETEmail;

    @BindView(R.id.et_password)
    EditText mETPassword;

    @OnClick(R.id.btn_login)
    public void onClickLogin(View view) {
        login(view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    private void login(View view) {
        String email = mETEmail.getText().toString().trim();
        String password = mETPassword.getText().toString().trim();

        mLogInPresenter.attachView(this);
        LoginRequest loginUserRequest = new LoginRequest();
        loginUserRequest.setEmail(email);
        loginUserRequest.setPassword(password);
        mLogInPresenter.loginUser(AndroidBoilerplateConstant.API_KEY, loginUserRequest);
    }

    @Override
    public void LoginUserDetails(LoginResponse loginUserResponse) {
        loginUserResponse.getData().setToken(loginUserResponse.getAccess_token());

        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showStart() {
        showProgress();
    }

    @Override
    public void showEnd() {
        dismissProgress();
    }

    @Override
    public void endError(int errorCode) {
        dismissProgress();
        Toast.makeText(this, AndroidBoilerplateHelper.getErrorMessage(this, errorCode), Toast.LENGTH_SHORT).show();
    }
}
