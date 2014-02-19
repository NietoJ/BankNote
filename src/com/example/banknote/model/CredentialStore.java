package com.example.banknote.model;

import java.util.ArrayList;

public class CredentialStore {
	private static ArrayList<String> names = new ArrayList<String>();
	private static ArrayList<String> passwords = new ArrayList<String>();
	
	public static void add(String name, String pass){
		names.add(name);
		passwords.add(pass);
	}
	
	public static ArrayList<String> getNames(){
		return names;
	}
	
	public static String getPassAtIndex(int index){
		return passwords.get(index);
	}
	
	public static boolean isIn(String name){
		return names.contains(name);
	}
	
	public static int getIndexOfName(String name){
		return names.lastIndexOf(name);
	}
}
