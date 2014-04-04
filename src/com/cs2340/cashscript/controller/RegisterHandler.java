package com.cs2340.cashscript.controller;

import com.cs2340.cashscript.model.CredentialStore;

public class RegisterHandler {

    public static boolean attemptRegister(String username, String password1,
            String password2) {
        if (username == null || username.equals("") || password1 == null
                || password1.equals("") || password2 == null
                || password2.equals("") || !password1.equals(password2)) {
            return false;
        }

        if (!CredentialStore.containsUser(username, password1)) {
            CredentialStore.addUser(username, password1);
            return true;
        }
        return false;
    }
}
