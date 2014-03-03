package com.example.banknote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class Dashboard extends Activity 
{


	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		
		//Allows you to get the user's name passed from login screen
//		Intent intent = getIntent();
//		String name = intent.getStringExtra(Login_screen.USER);
//		presenter = new DashboardPresenter(this, name);
	
	}
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dashboard, menu);
		return true;
	}
	
	public void goToFinAcc(View view){
		Intent intent = new Intent();
		intent.setClassName("com.example.banknote", "com.example.banknote.AddFinAccount");
		startActivity(intent);
	}

	

}
