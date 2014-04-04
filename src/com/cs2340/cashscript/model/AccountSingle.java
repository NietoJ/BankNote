package com.cs2340.cashscript.model;

public class AccountSingle {
    private static AccountSingle instance = null;
    private static Account currentAccount;

    private AccountSingle() {
    }

    public AccountSingle getInstance() {
        if (instance == null) {
            instance = new AccountSingle();
        }
        return instance;
    }

    public Account getCurrentaccount() {
        return currentAccount;
    }

    public static void setCurrentaccount(Account u) {
        currentAccount = u;
    }

}
