package com.example.mvptask.model;

import java.io.Serializable;

public class BankDetailsChildList implements Serializable {

    /**
     * BankAccount Sub list name
     */
    private String nameChild;
    /**
     * BankAccount Sub list Frost Id
     */
    private String frostId;
    /**
     * BankAccount Sub list Amount
     */
    private Double amount;
    /**
     * BankAccount Sub list Currency Symbol
     */
    private String currencySymbol;

    /**
     * @return Gets the value of nameChild and returns nameChild
     */
    public String getNameChild() {
        return nameChild;
    }

    /**
     * Sets the nameChild
     * You can use getNameChild() to get the value of nameChild
     */
    public void setNameChild(String nameChild) {
        this.nameChild = nameChild;
    }

    /**
     * @return Gets the value of frostId and returns frostId
     */
    public String getFrostId() {
        return frostId;
    }

    /**
     * Sets the frostId
     * You can use getFrostId() to get the value of frostId
     */
    public void setFrostId(String frostId) {
        this.frostId = frostId;
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
}
