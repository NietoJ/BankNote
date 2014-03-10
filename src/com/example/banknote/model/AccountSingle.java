package com.example.banknote.model;

public class AccountSingle {
	
	private static AccountSingle instance;
	private static Account currentAccount;
	
	 public AccountSingle(){
		 
	 }
	 
	 public AccountSingle(Account account){
		 currentAccount = account;
	 }
	 
	 public static AccountSingle getInstance(){
		 if(instance == null){
			 instance = new AccountSingle();
		 }
		 return instance;
	 }
	 
	 public static Account getCurrentAccount(){
		 return currentAccount;
	 }
	 
	 public static void setCurrentAccount(Account Account){
		 currentAccount = Account;
	 }

}