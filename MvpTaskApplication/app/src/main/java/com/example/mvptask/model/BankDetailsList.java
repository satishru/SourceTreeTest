package com.example.mvptask.model;

import java.util.ArrayList;
import java.util.List;

public class BankDetailsList {
    private List<BankDetails> accountData = new ArrayList<>();

    /**
     * @return Gets the value of accountData and returns accountData
     */
    public List<BankDetails> getAccountData() {
        return accountData;
    }

    /**
     * Sets the accountData
     * You can use getAccountData() to get the value of accountData
     */
    public void setAccountData(List<BankDetails> accountData) {
        this.accountData = accountData;
    }
}
