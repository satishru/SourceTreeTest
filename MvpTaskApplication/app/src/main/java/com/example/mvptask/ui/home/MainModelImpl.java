package com.example.mvptask.ui.home;

import com.example.mvptask.callback.Callback;
import com.example.mvptask.model.BankDetails;
import com.example.mvptask.utils.JsonUtils;

import java.util.List;

public class MainModelImpl implements MainContract.MainModel {

    /**
     * @param callback
     */
    @Override
    public void getMyAccountData(final onLoadDataCallBack callback) {
        JsonUtils.getBankData(new Callback() {
            @Override
            public void onLoadData(List<BankDetails> list) {
                callback.onDataLoaded(list);
            }

            @Override
            public void onFailure(String error) {
                callback.onFailure(error);
            }
        });
    }
}
