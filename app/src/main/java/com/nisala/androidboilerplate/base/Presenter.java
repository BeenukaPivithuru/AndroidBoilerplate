package com.nisala.androidboilerplate.base;

public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
