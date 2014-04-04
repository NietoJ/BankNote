package com.cs2340.cashscript.model;

public class Account {
    private String fullName;
    private String displayName;
    private double interest;
    private double balance;
    // The userID of the User this account belongs to
    private int userID;
    private int accountID;

    public Account(String fullName, String displayName, int id, double balance,
            double interest) {
        this.fullName = fullName;
        if (displayName == null || displayName.equals("")) {
            this.displayName = fullName;
        } else {
            this.displayName = displayName;
        }

        userID = id;
        this.balance = balance;
        this.interest = interest;
        accountID = this.hashCode();
    }

    public double getBalance() {
        return balance;
    }

    public double getInterest() {
        return interest;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getFullName() {
        return fullName;
    }

    public int getUserID() {
        return userID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setBalance(double newBalance) {
        balance = newBalance;
    }

    public void setFullName(String s) {
        fullName = s;
    }

    public void setDisplayName(String s) {
        displayName = s;
    }

    public void setInterest(double i) {
        interest = i;
    }
}
