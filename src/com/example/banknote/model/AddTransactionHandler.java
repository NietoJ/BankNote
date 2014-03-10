package com.example.banknote.model;

import android.content.Context;
import android.widget.Toast;

import java.util.regex.*;

public class AddTransactionHandler {
	
	private Transaction newTrans;
	
	public void addNewTrans (String type, String description, boolean isIncome, String amount) {
		
		double transAmount = Double.parseDouble(amount);
		
		// Negative amount for outcome transaction
		if (!isIncome) {
			transAmount = (-1)* transAmount;
		}
	
		// create new transaction by defined instructors
	 newTrans = new Transaction (type, description, isIncome, transAmount, AccountSingle.getCurrentAccount(), UserSingle.getCurrentUser());
	}
	
	public boolean isValidDescription(String name)
	{
		if (name == null || name.equals(""))
		{
			return false;
		}
		else return true;
	}
	
	public boolean isValidAmount(String transAmount)
	{
		if (transAmount == null || transAmount.equals(""))
		{
			return false;
		}
		

		if(!(transAmount.matches("[0-9]*\\.[0-9]{2}") || transAmount.matches("[0-9]*"))) //if transAmount is not in the correct format of a number
		{
			return false; 
		}
		else return true;
	}
	
	
	
}
