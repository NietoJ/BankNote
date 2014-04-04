/**
 * 
 */
package com.cs2340.cashscript.model;

/**
 * @author cameron
 * 
 */
public class User {
    private String username;
    private String password;
    private int id;

    public User() {

    }

    public User(String u, String p) {
        username = u;
        password = p;
        id = this.hashCode();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getID() {
        return id;
    }
}
