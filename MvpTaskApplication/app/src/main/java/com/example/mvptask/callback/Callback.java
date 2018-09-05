package com.example.mvptask.callback;

import com.example.mvptask.model.BankDetails;

import java.util.List;

public interface Callback {
    void onLoadData(List<BankDetails> list);
    void onFailure(String error);
}