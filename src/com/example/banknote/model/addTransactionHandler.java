package com.example.banknote.model;

import android.content.Context;
import android.widget.Toast;

public class addTransactionHandler {
	
	private Transaction newTrans;
	
	public void addNewTrans (String type, boolean isIncome, String amount, Account targetAccount, User targetUser ) {
		
		double transAmount = Double.parseDouble(amount);
		
		// Negative amount for outcome transaction
		if (!isIncome) {
			transAmount = (-1)* transAmount;
		}
		
	 newTrans = new Transaction (type, isIncome, transAmount, targetAccount, targetUser);
	 
	}
	
	public boolean isValid(){
		return false;
	}
	
}
