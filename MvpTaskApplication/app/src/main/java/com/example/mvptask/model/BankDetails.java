package com.example.mvptask.model;

import java.io.Serializable;
import java.util.List;

public class BankDetails implements Serializable{

    /**
     * BankAccount List Name
     */
    private String name;
    /**
     * BankAccount List Amount
     */
    private Double amount;
    /**
     * BankAccount List Currency Symbol
     */
    private String currencySymbol;

    /**
     * BankAccount Sub List
     */
    private List<BankDetailsChildList> accountChildDetails = null;

    /**
     * @return Gets the value of name and returns name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * You can use getName() to get the value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Gets the value of amount and returns amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Sets the amount
     * You can use getAmount() to get the value of amount
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * @return Gets the value of currencySymbol and returns currencySymbol
     */
    public String getCurrencySymbol() {
        return currencySymbol;
    }

    /**
     * Sets the currencySymbol
     * You can use getCurrencySymbol() to get the value of currencySymbol
     */
    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    /**
     * @return Gets the value of accountChildDetails and returns accountChildDetails
     */
    public List<BankDetailsChildList> getAccountChildDetails() {
        return accountChildDetails;
    }

    /**
     * Sets the accountChildDetails
     * You can use getAccountChildDetails() to get the value of accountChildDetails
     */
    public void setAccountChildDetails(List<BankDetailsChildList> accountChildDetails) {
        this.accountChildDetails = accountChildDetails;
    }
}
