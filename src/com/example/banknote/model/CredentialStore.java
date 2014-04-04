package com.example.banknote.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class CredentialStore implements Serializable {
	// Holds users, each with a name and password
	private static ArrayList<User> users = new ArrayList<User>();
	private static String filename = "banknote.dat";
	/**
	 * Creates a new user and adds it to the collection of users
	 * 
	 * @param name
	 * @param password
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void add(String name, String password){
		try {
			setupUserList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User u = new User(name, password);
		users.add(u);

		UserSingle.getInstance();
		UserSingle.setCurrentUser(u);
	}

	/**
	 * Returns a lists of the user names
	 * 
	 * @return
	 */
	public static ArrayList<String> getNames() {
		ArrayList<String> names = new ArrayList<String>();
		for (User u : users) {
			names.add(u.getName());
		}
		return names;
	}

	/**
	 * Determines if a username already exists
	 * 
	 * @param name
	 * @return true if the name already exists
	 */
	public static boolean containsName(String name) {
		for (User u : users) {
			if (u.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns a list of the user passwords
	 * 
	 * @return
	 */
	public static ArrayList<String> getPassWords() {
		ArrayList<String> passwords = new ArrayList<String>();
		for (User u : users) {
			passwords.add(u.getPassword());
		}
		return passwords;
	}

	/**
	 * Determines if a user with a given name and password exists
	 * 
	 * @param name
	 * @param password
	 * @return true if the user exists
	 */
	public static boolean containsNameAndPassword(String name, String password) {
		for (User u : users) {
			if (u.getName().equals(name) && u.getPassword().equals(password))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the user with the same name
	 * 
	 * @param name
	 * @return the user, NULL IF NOT FOUND
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static User getUser(String name){
		try {
			getUserList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (User u : users) {
			if (u.getName().equals(name)) {
				return u;
			}
		}
		return null;
	}

	private static void setupUserList() throws IOException{
		ObjectOutputStream fos = new ObjectOutputStream(new BufferedOutputStream(
				new FileOutputStream(filename)));
		users.add(new User("admin", "pass123"));
		fos.writeObject(users);
		fos.close();
	}
	
	public static void saveUserList() throws IOException {
		ObjectOutputStream fos = new ObjectOutputStream(new BufferedOutputStream(
				new FileOutputStream(filename)));
		fos.writeObject(users);
		fos.close();
	}

	@SuppressWarnings("unchecked")
	public static void getUserList() throws IOException, ClassNotFoundException{
		ObjectInputStream fin = new ObjectInputStream(new BufferedInputStream(
				new FileInputStream(filename)));
		users = (ArrayList<User>) fin.readObject();
		fin.close();
	}
	
	public void updateUsers() {
		String filename = "users.ser";

	    // save the object to file
	    FileOutputStream fos = null;
	    ObjectOutputStream out = null;
	    try {
	      fos = new FileOutputStream(filename);
	      out = new ObjectOutputStream(fos);
	      out.writeObject(users);

	      out.close();
	    } catch (Exception ex) {
	      ex.printStackTrace();
	    }
	    // read the object from file
	    // save the object to file
	    FileInputStream fis = null;
	    ObjectInputStream in = null;
	    try {
	      fis = new FileInputStream(filename);
	      in = new ObjectInputStream(fis);
	      ArrayList<User> inputUsers = (ArrayList<User>) in.readObject();
	      in.close();
	    } catch (Exception ex) {
	      ex.printStackTrace();
	    }
	}
	
	public void readFromFile() {
	    FileInputStream fis = null;
	    ObjectInputStream in = null;
	    try {
	      fis = new FileInputStream(filename);
	      in = new ObjectInputStream(fis);
	      ArrayList<User> inputUsers = (ArrayList<User>) in.readObject();
	      in.close();
	    } catch (Exception ex) {
	      ex.printStackTrace();
	    }
	}
}
