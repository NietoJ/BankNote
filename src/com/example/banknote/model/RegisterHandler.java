package com.example.banknote.model;

public class RegisterHandler 
{

	/**
	 * Attempts to add a new user with name and password to the store of users
	 * @param name
	 * @param password
	 * @return true if successful
	 */
	public static boolean store(String name, String password) 
	{
		if (isValidName(name) && isValidPass(password)) 
		{
			CredentialStore.add(name, password);
			return true;
		}	
		return false;
	}

	/**
	 * Determines if a username is valid
	 * @param str
	 * @return true if valid
	 */
	public static boolean isValidName(String str) 
	{
		if (str == null || CredentialStore.containsName(str) || str.equals("")) 
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Determines if a password is valid for user
	 * @param str
	 * @return
	 */
	public static boolean isValidPass(String str) 
	{
		if (str == null || str.equals("")) 
		{
			return false;
		}
		return true;
	}
}
