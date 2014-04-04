package com.cs2340.cashscript.controller;

import com.cs2340.cashscript.model.CredentialStore;
import com.cs2340.cashscript.model.UserSingle;

public class NewAccountHandler {
    public boolean createNewAccount(String fullName, String balance) {
        int userID = UserSingle.getCurrentUser().getID();
        double b;
        if (fullName == null || fullName.equals("")) {
            return false;
        }
        try {
            b = Double.parseDouble(balance);
        } catch (Exception ex) {
            return false;
        }

        CredentialStore.addAccount(fullName, fullName, userID, b, 0);
        return true;
    }
}
