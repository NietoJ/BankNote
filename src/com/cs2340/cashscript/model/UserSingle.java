package com.cs2340.cashscript.model;

import android.util.Log;

public class UserSingle {
    private static UserSingle instance = null;
    private static User currentUser;

    private UserSingle() {
        Log.d("execute", "execute");
    }

    public static UserSingle getInstance() {
        if (instance == null) {
            instance = new UserSingle();
        }
        return instance;
    }

    public static User getCurrentUser() {
        getInstance();
        return currentUser;
    }

    public static void setCurrentUser(User u) {
        getInstance();
        currentUser = u;
    }

}
