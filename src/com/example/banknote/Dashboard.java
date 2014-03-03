package com.example.banknote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.example.banknote.model.User;
import com.example.banknote.presenter.DashboardPresenter;

public class Dashboard extends Activity 
{

	
	private static final String USER = "com.example.banknote.USER"; //used to pass user name to next screen
	DashboardPresenter presenter;
	String name;//the name of the user who's logged in
	View view;//records view so it can be passed to goToAddAccountScreen
	User user;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		
		//Allows you to get the user's name passed from login screen
		Intent intent = getIntent();
		String name = intent.getStringExtra(Login_screen.USER);
		presenter = new DashboardPresenter(this, name);
	
	}
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dashboard, menu);
		return true;
	}
	
	/** Called when the user clicks the Log In button */
	public void goToLogInScreen(View view)	
	{
		Intent intent = new Intent(this, Login_screen.class);
		startActivity(intent);
	}
	

	public void goToAddAccountScreen(View view)
	{
		Intent intent = new Intent(this, Fin_Account_Reg.class);
		intent.putExtra(USER, name); 
		startActivity(intent);
	}

	//Linked to button in activity_dashboard.xml
	//Calls the dashboard presenter to notify of button click
	public void notifyPresenterNewAccountButtonClick(View view)
	{
		presenter.newAccountButtonClick();
		view = this.view;//records the view so it can be passed to the goToAddAccountScreen when the presenter tells us to
	}
	
	//Will be called by presenter after presenter is notified of click
	public void goToAddAccount() 
	{
		goToAddAccountScreen(view);	 
	}





}
