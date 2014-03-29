package com.example.banknote.model;

public class UserSingle {
	
	private static UserSingle instance;
	private static User currentUser;
	
	 private UserSingle(){
		 
	 }
	 
	 private UserSingle(User user){
		 currentUser = user;
	 }
	 
	 public static UserSingle getInstance(){
		 if(instance == null){
			 instance = new UserSingle();
		 }
		 return instance;
	 }
	 
	 public static User getCurrentUser(){
		 return currentUser;
	 }
	 
	 public static void setCurrentUser(User user){
		 currentUser = user;
	 }

}
