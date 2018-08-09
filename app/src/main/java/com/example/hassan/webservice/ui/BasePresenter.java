package com.example.hassan.webservice.ui;

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView(V view);

    boolean isAttached();
}
