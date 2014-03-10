package com.example.banknote.model;

import java.util.ArrayList;
import java.util.LinkedList;

import android.content.Context;
import android.widget.Toast;

public class AddAccountHandler 
{
	//private static ArrayList<Account> accounts = UserSingle.getCurrentUser().getAccounts();
	private static ArrayList<Account> accounts ;
	public static boolean isValidName(String name)
	{
		if (name == null || name.equals(""))
		{
			return false;
		}
		else return true;
	}
	
	public static boolean nameAlreadyExists(String fullName, String displayName)
	{
		if (accounts == null)
		{
			return false;
		}
		
		for (Account a: accounts)
		{
			if (a == null)
			{		
				return false;
			}	
			if (a.getFullName().equals(fullName) || a.getDisplayName().equals(displayName))
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean isValidInterestRate(String ir)
	{
		if (!(ir == null || ir.equals("")))
		{
			return true;
		}
		
		double irDouble= Double.parseDouble(ir);
		
		
		if (irDouble < 0)
		{
			return false;
		}
		else return true;
	}
	
	
	public static boolean isValidAmount(String amount)
	{
		if (amount == null || amount.equals(""))
		{
			return false;
		}
		
		//if amount is not in the correct format of a number
		if(!(amount.matches("[0-9]*\\.[0-9]{2}"))) 
		{
			return false; 
		}
		else return true;
	}
	

	public static void addAccount(String fullName, String displayName, String balance, String interestRate)
	{
		double balanceDouble = Double.parseDouble(balance);
		double irDouble = Double.parseDouble(interestRate);
		
		if (displayName == null || displayName.equals("")) {
			displayName = fullName;
		}
		
		Account account = new Account(fullName, displayName, balanceDouble, irDouble);	
		
		// Add the new account into Accounts List of current user.
		User currentUser = UserSingle.getCurrentUser();
		currentUser.addAccount(account);
		
		
		AccountSingle.getInstance();
		AccountSingle.setCurrentAccount(account);
		
		// Set initial balance for the new account (Transaction)
		account.getHistory().setIntBalacce(balanceDouble);
	}
	
}
