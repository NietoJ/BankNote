package com.example.banknote.model;

import java.util.ArrayList;
import java.util.List;

/**
 * History class contain the list of transactions associate with financial account or a user account.
 * @author Nghia Huynh
 *
 */

public class History {
	
	/*
	 * ArrayList of transaction
	 */
	private List<Transaction> transList;
	
	public History (){
		transList = new ArrayList<Transaction>();
	}
	
	
	/**
	 * Adds new transaction in the the Transaction List in the History
	 * @param newTrans: the new transaction added to the list
	 * @return transAmount (double): the amount of the added transaction
	 */
	private double addNewTrans (Transaction newTrans) {
		transList.add(newTrans);
		return newTrans.getAmount();
		
	}
	
	
	
}
