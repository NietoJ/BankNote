/**
 * 
 */
package com.example.banknote.presenter;

import com.example.banknote.Dashboard;
import com.example.banknote.model.CredentialStore;
import com.example.banknote.model.User;

/**
 * @author jacksonkmillsaps
 *
 */
public class DashboardPresenter 
{
	User user;
	Dashboard dashboard;
	
	
	public DashboardPresenter(Dashboard d, String name)
	{
		user = CredentialStore.getUser(name);;
		dashboard = d;
	}
	
	public void newAccountButtonClick() 
	{
		dashboard.goToAddAccount();		
	}
	
}
