package com.nisala.androidboilerplate.login;

import com.nisala.androidboilerplate.base.BasePresenter;
import com.nisala.androidboilerplate.data.DataManager;
import com.nisala.androidboilerplate.data.model.request.LoginRequest;
import com.nisala.androidboilerplate.data.model.response.LoginResponse;
import com.nisala.androidboilerplate.util.RxUtil;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

/**
 * Created by nisala on 12,October,2018
 */
public class LoginPresenter extends BasePresenter<LoginMvpView> {
    private final DataManager mDataManager;

    private Disposable mDisposable;

    @Inject
    public LoginPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(LoginMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mDisposable != null) mDisposable.dispose();
    }

    public void loginUser(String apikey, LoginRequest loginUserRequest) {
        checkViewAttached();
        RxUtil.dispose(mDisposable);
        mDataManager.loginUser(apikey, loginUserRequest)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<LoginResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                        getMvpView().showStart();
                    }

                    @Override
                    public void onNext(LoginResponse loginUserResponse) {
                        getMvpView().LoginUserDetails(loginUserResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        try {
                            getMvpView().endError(((HttpException) e).code());
                        } catch (ClassCastException cce) {

                        }
                    }

                    @Override
                    public void onComplete() {
                        getMvpView().showEnd();
                    }
                });
    }

}

