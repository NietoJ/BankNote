package com.example.banknote.model;


public class LoginHandler 
{
	private static void setUpDefaultCredentials() 
	{
		CredentialStore.add("admin","pass123");
	}

	public static boolean attemptLogin(String name, String password) 
	{
		// Adds default admin account to list
		setUpDefaultCredentials();
		return CredentialStore.containsNameAndPassword(name, password);
	}
	
	public static User getUser(String name)
	{
		return CredentialStore.getUser(name);
	}
}

