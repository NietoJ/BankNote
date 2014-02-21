package com.example.banknote.model;

public class RegisterHandler {

	public static boolean store(String name, String password) {
		if (isValidName(name) && isValidPass(password)) {
			CredentialStore.add(name, password);
			return true;
		}	
		return false;
	}

	public static boolean isValidName(String str) {
		if (str == null || CredentialStore.isIn(str) || str.equals("")) {
			return false;
			
		}
		return true;
	}
	
	public static boolean isValidPass(String str) {
		if (str == null || str.equals("")) {
			return false;
		}
		return true;
	}
}
