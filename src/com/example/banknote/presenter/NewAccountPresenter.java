package com.example.banknote.presenter;

import com.example.banknote.Fin_Account_Reg;
import com.example.banknote.model.Account;
import com.example.banknote.model.User;

public class NewAccountPresenter 
{
	Fin_Account_Reg screen;
	User user;
	
	NewAccountPresenter(Fin_Account_Reg screen, User user)
	{
		this.screen = screen;
		this.user = user;
	}
	
	public void addAccountButtonClick()
	{
		String fullName = screen.getFullName();
		String displayName = screen.getDisplayName();
		double balance = screen.getBalence();
		double interestRate = screen.getInterestRate();
		
		areValidNames(fullName, displayName);
		Account account = new Account(fullName, displayName, balance, interestRate);
		user.addAccount(account);
		
	}

	private boolean areValidNames(String fullName, String displayName) 
	{
		ArrayList<Accounts> accounts = user.getAccounts();
	}
}
