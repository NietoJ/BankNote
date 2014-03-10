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
		if (CredentialStore.containsNameAndPassword(name, password))
		{
			UserSingle.getInstance();
			User u = CredentialStore.getUser(name);
			UserSingle.setCurrentUser(u);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static User getUser(String name)
	{
		return CredentialStore.getUser(name);
	}
}
