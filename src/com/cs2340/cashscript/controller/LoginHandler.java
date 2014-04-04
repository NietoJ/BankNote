package com.cs2340.cashscript.controller;

import com.cs2340.cashscript.model.CredentialStore;
import com.cs2340.cashscript.model.User;
import com.cs2340.cashscript.model.UserSingle;

public class LoginHandler {
    private LoginHandler() {

    }

    public static boolean attemptLogin(String username, String password) {
        if (CredentialStore.containsUser(username, password)) {
            UserSingle.setCurrentUser(new User(username, password));
            return true;
        }
        return false;
    }
}
