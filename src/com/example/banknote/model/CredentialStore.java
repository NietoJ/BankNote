package com.example.banknote.model;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;

public class CredentialStore {
	private static String filename = "users.dat";
	private static Collection<User> userList;
	private static boolean isSetUp = false;
	
	public static void add(String name, String password){
		User u = new User(name, password);
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(filename, true);
			out = new ObjectOutputStream(fos);
			out.writeObject(u);
			out.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static User getUser(String name){
		for(User u: userList){
			if(u.getName().equals(name)){
				return u;
			}
		}
		return null;
	}
	
	
	public boolean containsUser(User u){
		if(!isSetUp){
			setupUserList(); 
		}
		
		for(User userInList: userList){
			if(User.nameEquals(u, userInList)){
				return true;
			}
		}
		return false;
	}
	
	// populates the Collection with Users from file
	private static void setupUserList(){
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			User u;
			while(in.available() > 1 && (u = (User) in.readObject()) != null){
				userList.add(u);
			}
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		for(User fin: userList){
			System.out.println(fin);
		}
	}
	
	public static boolean containsName(String name){
		if(!isSetUp){
			setupUserList();
		}
		for(User userInList: userList){
			if(name.equals(userInList.getName())){
				return true;
			}
		}
		return false;
	}

	public static boolean containsNameAndPassword(String name, String password) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
