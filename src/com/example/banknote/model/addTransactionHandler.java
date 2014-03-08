package com.example.banknote.model;

public class addTransactionHandler {
	
	private Transaction newTrans;
	
	public void addNewTrans ( String type, boolean isIncome, String amount, Account targetAccount, User targetUser ) {
		
		double transAmount = Double.parseDouble(amount);
		
		// Negative amount for outcome transaction
		if (!isIncome) {
			transAmount = (-1)* transAmount;
		}
		
		Transaction newTrans = null;
		
		newTrans.setType(type);
		newTrans.setIsIncome(isIncome);
		newTrans.setRecordedTime();
		newTrans.setAmount(transAmount);
		newTrans.setTargetAccount(targetAccount);
		newTrans.setTargetUser(targetUser);
		
		// Transaction newTrans = new Transaction ( type, transAmount, targetAccount, targetUser );
	}
	
}
