package com.example.mvptask.ui.base;

public interface BaseView {

    void showLoading();

    void hideLoading();

    void onError(String message);
}
