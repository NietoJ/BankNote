package com.example.banknote;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.example.banknote.presenter.NewAccountPresenter;

public class Fin_Account_Reg extends Activity {
	
	private NewAccountPresenter presenter;
	View view;
	
	private String fullName;
	private String displayName;
	private String balance;
	private String interestRate;

	private EditText finacc_fulname;
	private EditText finacc_displayname;
	private EditText finacc_balance;
	private EditText finacc_interest_rate;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fin__account__reg);
		
		
		finacc_fulname = (EditText) findViewById(R.id.finacc_fulname);
		finacc_displayname = (EditText) findViewById(R.id.finacc_displayname);
		finacc_balance = (EditText) findViewById(R.id.finacc_balance);
		finacc_interest_rate = (EditText) findViewById(R.id.finacc_interest_rate);
				
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fin__account__reg, menu);
		return true;
	}
	
	
	public void notifyPresenterAddAccountButtonClick(View view) 
	{
		fullName = finacc_fulname.getText().toString();
		displayName = finacc_displayname.getText().toString();
		balance = finacc_balance.getText().toString();
		interestRate = finacc_interest_rate.getText().toString();
		presenter.addAccountButtonClick();
		this.view = view;
	}
		
	public String getFullName() 
	{
		return fullName;
	}

	public String getDisplayName() 
	{
		return displayName;
	}

	public double getBalence() 
	{
		return Double.parseDouble(balance);
	}

	public double getInterestRate() 
	{
		return Double.parseDouble(interestRate);
	}

}
