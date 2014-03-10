package com.example.banknote.model;

public class AccountSingle {
	
	private static AccountSingle instance;
	
	private Account currentAccount;
	
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
	 
	 public Account getCurrentAccount(){
		 return currentAccount;
	 }
	 
	 public void setCurrentAccount(Account account){
		 currentAccount = account;
	 }

}
