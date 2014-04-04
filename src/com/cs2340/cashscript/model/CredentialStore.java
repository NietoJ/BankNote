package com.cs2340.cashscript.model;

import java.util.ArrayList;
import java.util.Collection;

public class CredentialStore {
    private static Collection<User> userList = new ArrayList<User>();
    private static Collection<Account> accountList = new ArrayList<Account>();

    public static boolean containsUser(String username, String password) {
        for (User u : userList) {
            if (username.equals(u.getUsername())) {
                if (password.equals(u.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsUsername(String username) {
        for (User u : userList) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static boolean addUser(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        if (!containsUsername(username)) {
            userList.add(new User(username, password));
            return true;
        }
        return false;
    }

    public static boolean addAccount(String fullName, String displayName,
            int id, double balance, double interest) {
        if (fullName == null || displayName == null) {
            return false;
        }
        if (!containsAccountFullName(fullName)) {
            accountList.add(new Account(fullName, displayName, id, balance,
                    interest));
            return true;
        }
        return false;
    }

    public static boolean containsAccountFullName(String fullName) {
        for (Account a : accountList) {
            if (a.getFullName().equals(fullName)) {
                return true;
            }
        }
        return false;
    }

}
