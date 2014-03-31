package com.example.banknote.model;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;

public class RegisterHandler {

	public static boolean store(String name, String password) 
	{
		ObjectContainer db = DBSingle.getInstance().getDB();
		User u = new User();
		u.setName("buck");
		u.setPassword("wild");
		db.store(u);
	//	db.commit();

		


		
		
		
		
		return true;
	}
}
//	}
//	
//	
//	public static boolean store(String name, String password) {
//		if (isValidName(name) && isValidPassword(password)) {
//			CredentialStore.add(name, password);
//			return true;
//		}	
//		return false;
//	}
//	
//	public static boolean isValidName(String str) {
//		if (str == null || CredentialStore.containsName(str) || str.equals("")) {
//			return false;
//		}
//		return true;
//	}
//
//	public static boolean isValidPassword(String str) {
//		if (str == null || str.equals("")) {
//			return false;
//		}
//		return true;
//	}

	

