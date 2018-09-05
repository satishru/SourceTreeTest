package com.example.mvptask.ui.home;

import com.example.mvptask.model.BankDetails;

import java.util.List;

public class MainPresenterImpl implements MainContract.MainPresenter, MainContract.MainModel.onLoadDataCallBack {

    private MainContract.MainView mainView;
    private MainContract.MainModel mainModel;

    public MainPresenterImpl(MainContract.MainView mainView,MainContract.MainModel mainModel) {
        this.mainView = mainView;
        this.mainModel = mainModel;
    }

    @Override
    public void loadMyAccountData() {
        mainModel.getMyAccountData(this);
    }

    @Override
    public void onDataLoaded(List<BankDetails> list) {
        mainView.setMyAccountData(list);
    }

    @Override
    public void onFailure(String message) {
        mainView.onError(message);
    }
}
