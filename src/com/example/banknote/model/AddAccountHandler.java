package com.example.banknote.model;

import java.util.ArrayList;
import java.util.LinkedList;

public class AddAccountHandler 
{
	private static ArrayList<Account> accounts = UserSingle.getCurrentUser().getAccounts();
	
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
		if (ir == null || ir.equals(""))
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
	

	public static Account addAccount(String fullName, String displayName, String balance, String interestRate)
	{
		Account a = new Account();
		
		double balanceDouble = Double.parseDouble(balance);
		a.setFullName(fullName);
		a.setDisplayName(displayName);
		if (balance != null && !balance.equals(""))
		{
			a.setBalance(balanceDouble);
		}
		if (interestRate != null && !interestRate.equals(""))
		{
			double irDouble = Double.parseDouble(interestRate);
			a.setBalance(irDouble);
		}
		
		// Set initial balance for the new account (Transaction)
		a.getHistory().setIntBalacce(balanceDouble);
		
		// Add the new account into Accounts List of current user.
		UserSingle.getCurrentUser().getAccounts().add(a);
		
		return a;
	}
	
}
