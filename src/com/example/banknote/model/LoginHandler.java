package com.example.banknote.model;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.ext.Db4oRecoverableException;
import com.db4o.query.Predicate;


public class LoginHandler 
{
	private static void setUpDefaultCredentials() 
	{
		CredentialStore.add("admin","pass123");
	}

	public static boolean attemptLogin(final String name, String password) 
	{
		// Adds default admin account to list
		//setUpDefaultCredentials();
	
		ObjectContainer db = DBSingle.getInstance().getDB();
		
		try
		{
			List<User> users = db.query(new Predicate<User>()
			{
				public boolean match(User u)
				{
					return u.getName().equals(name);
				}
			});
			User u = users.get(0); // get first returned User - should only be one
			if (u.getPassword().equals(password))
			{
				UserSingle.getInstance().setCurrentUser(u);
				return true;
			}
			
		}
		catch (Db4oRecoverableException e)
		{
			return false;
		}
			

		return false;
	}
}
	
		
		
		
//		if (CredentialStore.containsNameAndPassword(name, password))
//		{
//
//			User u = CredentialStore.getUser(name);
//			UserSingle.getInstance();
//			UserSingle.setCurrentUser(u);
//			return true;
//		}
//		else
//		{
//			return false;
//		}
//	}
//	
//	public static User getUser(String name)
//	{
//		return CredentialStore.getUser(name);
//	}

