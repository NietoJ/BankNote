package com.example.banknote.view;

import com.example.banknote.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Dashboard extends Activity 
{
	private Button btnViewAcc;
	private Button btnAddFinAcc;
	private String text = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		
		//Allows you to get the user's name passed from login screen
//		Intent intent = getIntent();
//		String name = intent.getStringExtra(Login_screen.USER);
//		presenter = new DashboardPresenter(this, name);
		btnViewAcc = (Button) findViewById(R.id.view_fin_account);
		btnAddFinAcc = (Button) findViewById(R.id.finacc_add_button);
	
	}
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dashboard, menu);
		
		findViewById(R.id.view_fin_account).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) { 
						text = "com.example.banknote.FinancialAccountMain";
						goNextActivity(view);
					}
				});
		
		findViewById(R.id.finacc_add_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) { 
						text = "com.example.banknote.AddFinAccount";
						goNextActivity(view);
					}
				});
		
		return true;
	}
	
	public void goNextActivity(View view){
		Intent intent = new Intent();
		intent.setClassName("com.example.banknote", text);
		startActivity(intent);
	}
}
