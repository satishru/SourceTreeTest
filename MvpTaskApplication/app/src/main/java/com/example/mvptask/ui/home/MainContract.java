package com.example.mvptask.ui.home;

import com.example.mvptask.model.BankDetails;
import com.example.mvptask.ui.base.BaseView;

import java.util.List;

public interface MainContract {

    interface MainView extends BaseView {

        void setMyAccountData(List<BankDetails> list);
    }

    interface MainPresenter {

        void loadMyAccountData();
    }

    interface MainModel {

        interface onLoadDataCallBack {
            void onDataLoaded(List<BankDetails> list);
            void onFailure(String message);
        }

        void getMyAccountData(onLoadDataCallBack callback);
    }
}
