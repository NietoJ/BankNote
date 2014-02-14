package com.example.banknote.model;

import java.util.ArrayList;

public class LoginHandler {
	private static ArrayList<String> loginCredentials = new ArrayList<String>();

	
	
	private static void setUpDefaultCredentials() {
		loginCredentials.add("admin:pass123");
	}

	public static boolean attemptLogin(String username, String password) {

		
		// Adds default admin account to arraylist
		setUpDefaultCredentials();
		for (String pair : loginCredentials) {
			String[] pieces = pair.split(":");
			if (pieces[0].equals(username)) {
				// Account exists, return true if the password matches.
				return pieces[1].equals(password);
			}
		}
		return false;
	}
}
