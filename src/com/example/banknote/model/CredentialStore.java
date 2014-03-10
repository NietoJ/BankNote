package com.example.banknote.model;

import java.util.ArrayList;

public class CredentialStore 
{
	//Holds users, each with a name and password
	private static ArrayList<User> users = new ArrayList<User>();
	
	/**
	 * Creates a new user and adds it to the collection of users
	 * @param name
	 * @param password
	 */
	public static void add(String name, String password)
	{
		User u = new User(name,password);
		users.add(u);
		
		UserSingle.getInstance();
		UserSingle.setCurrentUser(u);
	}
	
	/**
	 * Returns a lists of the user names
	 * @return
	 */
	public static ArrayList<String> getNames()
	{
		ArrayList<String>names = new ArrayList<String>();
		for (User u : users)
		{
			names.add(u.getName());
		}
		return names;
	}
	
	
	/**
	 * Determines if a username already exists
	 * @param name
	 * @return true if the name already exists
	 */
	public static boolean containsName(String name)
	{
		for (User u: users)
		{
			if (u.getName().equals(name))
			{
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Returns a list of the user passwords
	 * @return
	 */
	public static ArrayList<String> getPassWords()
	{
		ArrayList<String>passwords = new ArrayList<String>();
		for (User u : users)
		{
			passwords.add(u.getPassword());
		}
		return passwords;
	}
	
	/**
	 * Determines if a user with a given name and password exists
	 * @param name
	 * @param password
	 * @return true if the user exists
	 */
	public static boolean containsNameAndPassword(String name, String password)
	{
		for (User u : users)
		{
			if (u.getName().equals(name) && u.getPassword().equals(password)) //do both name and pass match that of a user?
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns the user with the same name
	 * @param name
	 * @return the user, NULL IF NOT FOUND
	 */
	public static User getUser(String name)
	{
		for (User u : users)
		{
			if (u.getName().equals(name))
			{
				return u;
			}
		}
		return null;
	}
}
