package com.example.banknote.model;


public class LoginHandler {
	
	private static void setUpDefaultCredentials() {
		CredentialStore.add("admin","pass123");
	}

	public static boolean attemptLogin(String username, String password) {

		// Adds default admin account to arraylist
		setUpDefaultCredentials();
		for (String name : CredentialStore.getNames()) {
			if (name.equals(username)) {
				// Account exists, return true if the password matches.
				return CredentialStore.getPassAtIndex(CredentialStore.getIndexOfName(name)).equals(password);
			}
		}
		return false;
	}
}
