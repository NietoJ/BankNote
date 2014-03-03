package com.example.banknote;

import com.example.banknote.model.addAccountHandler;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddFinAccount extends Activity {

	private String displayName = "";
	private String fullName = "";
	private String balance ="";
	private String interestRate ="";

	private EditText displayNameET;
	private EditText fullNameET;
	private EditText balanceET;
	private EditText interestRateET;

	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_fin_account);
		
		
		displayNameET = (EditText) findViewById(R.id.text_field_finacc_displayname);
		fullNameET = (EditText) findViewById(R.id.text_field_fullname);
		balanceET = (EditText) findViewById(R.id.text_field_finacc_balance);
		interestRateET = (EditText) findViewById(R.id.text_field_finacc_interest_rate);
		addAccountHandler.setup();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_fin_account, menu);
		return true;
	}
	
	public void makeNewFinAcc(View view)
	{
		
		displayName = displayNameET.getText().toString();
		fullName = fullNameET.getText().toString();
		balance = balanceET.getText().toString();
		interestRate = interestRateET.getText().toString();

		CharSequence text;
		
		if (!addAccountHandler.isValidName(fullName))
		{
			text = "Invalid Full Name";
		}
		
		else if (addAccountHandler.nameAlreadyExists(fullName, displayName))
		{
			text = "Account with that name already exists.";
		}

		else if (!addAccountHandler.isValidInterestRate(interestRate))
		{
			text = "Interest rate cannot be negative";
		}
		else
		{
			addAccountHandler.addAccount(fullName, displayName, balance, interestRate);
			text = "New Account Created!";
		}
		
		
		Context c = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(c, text, duration);
		toast.show();
	}

}
