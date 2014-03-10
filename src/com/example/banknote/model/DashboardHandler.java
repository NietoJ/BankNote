package com.example.banknote.model;

import java.util.List;

import android.content.Context;
import android.widget.Toast;

public class DashboardHandler {

	public static void initializeList( List<String> list) {
		// Initialize the list with all the accounts in user by DisplayName
		if ( UserSingle.getCurrentUser().getAccounts() == null ) {
			list.add("You have no account to view!");
		} else {
			for ( Account a : UserSingle.getCurrentUser().getAccounts() ) {
				list.add(a.getDisplayName());
			}
		}
	}
	
	/*
	 * return: true when the selected account is in the list
	 * return: false when the list is null
	 */
	public static boolean updateSelectedAccount (String selectedAccount, int selectedAccountIndex, List<String> list){
		
		if( !(UserSingle.getCurrentUser().getAccounts() == null)) {
			selectedAccountIndex = list.indexOf(selectedAccount) ;
			}
				
		if ( selectedAccountIndex != -1){
			AccountSingle.getInstance();
			AccountSingle.setCurrentAccount(UserSingle.getCurrentUser().getAccounts().get(selectedAccountIndex));
			return true;		
		} else {
			return false;
		}
	}
	
	
}
