package com.example.banknote;

import com.example.banknote.model.RegisterHandler;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Fin_Account_Reg extends Activity {
	
	private String accFullname;
	private String accDisplayName;
	private String accBalance;
	private String accIntRate;

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
		
		findViewById(R.id.finacc_reg_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) { // this "view" is the button
						attemptRegister(view);
					}
				});
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fin__account__reg, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void attemptRegister(View view) {
		
		accFullname = finacc_fulname.getText().toString();
		accDisplayName = finacc_displayname.getText().toString();
		accBalance = finacc_balance.getText().toString();
		accIntRate = finacc_interest_rate.getText().toString();
		
	// PRESETER OPERATION
		
	}

}
