package com.example.banknote.view;

import java.util.ArrayList;
import java.util.List;

import com.example.banknote.R;
import com.example.banknote.model.Account;
import com.example.banknote.model.AccountSingle;
import com.example.banknote.model.DashboardHandler;
import com.example.banknote.model.UserSingle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Dashboard extends Activity 
{
	private Button btnViewAcc;
	private Button btnAddFinAcc;
	private Spinner spinner;
	private String text = "";
	
	
	//Spinner helper to retrieve the selected Account as String
	private String selectedAccount = "";
	private int selectedAccountIndex = -1;
	
	
	List<String> list = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		

		btnViewAcc = (Button) findViewById(R.id.view_fin_account);
		btnAddFinAcc = (Button) findViewById(R.id.finacc_add_button);
		
		//Spinnner
		spinner = (Spinner) findViewById(R.id.account_spinner);
		
		/*
		 * selectedType Spinner
		 */
		spinnerUpdate();
		
		// Spinner item selection Listener  
        addListenerOnSpinnerItemSelection();
	
	}
	
	// Initialize the options in spinner with Accounts List in User
	private void spinnerUpdate() {
		// TODO Auto-generated method stub
		
		DashboardHandler.initializeList(list);
		
		/*
		// Initialize the list with all the accounts in user by DisplayName
		if ( UserSingle.getCurrentUser().getAccounts() == null ) {
			list.add("You have no account to view!");
		} else {
			for ( Account a : UserSingle.getCurrentUser().getAccounts() ) {
				list.add(a.getDisplayName());
			}
		}
		*/
		
		
		
		// Create an ArrayAdapter using the string array and a default spinner layout
		adapter = new ArrayAdapter<String>
         (this, android.R.layout.simple_spinner_item,list);
				
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
	}
	
	public void addListenerOnSpinnerItemSelection() {
		// TODO Auto-generated method stub
		CustomOnItemSelectedListener selectTypeListener = new CustomOnItemSelectedListener();
		spinner.setOnItemSelectedListener(selectTypeListener);
		
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
						
						if (attemptToView()) {
							text = "com.example.banknote.view.FinancialAccountMain";
							goNextActivity(view);
						} else {
							Context context = getApplicationContext();
							CharSequence text = "You have no account, please create one?";
							int duration = Toast.LENGTH_SHORT;
							Toast toast = Toast.makeText(context, text, duration);
							toast.show();
						}
					
					}
				});
		
		findViewById(R.id.finacc_add_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) { 
						text = "com.example.banknote.view.AddFinAccount";
						goNextActivity(view);
					}
				});
	
		return true;
	}
	
	public boolean attemptToView(){
		
		// Update the selectedAccount with the string of DisplayName
		
		// DashboardHandler.updateAccountIn();
		selectedAccount = (String) spinner.getSelectedItem();
		
		/*
		
		if( !(UserSingle.getCurrentUser().getAccounts() == null)) {
			selectedAccountIndex = list.indexOf(selectedAccount) ;
			}
				
		if ( selectedAccountIndex != -1){
			AccountSingle.getInstance();
			AccountSingle.setCurrentAccount(UserSingle.getCurrentUser().getAccounts().get(selectedAccountIndex));
			Context context = getApplicationContext();
			CharSequence text = " " + selectedAccountIndex;
			int duration = Toast.LENGTH_SHORT;
			Toast toast = Toast.makeText(context, selectedAccount, duration);
			toast.show();
			return true;		
		} 
		*/
	
		return DashboardHandler.updateSelectedAccount(selectedAccount, selectedAccountIndex, list);
		
	}
	
	public void goNextActivity(View view){
		Intent intent = new Intent();
		intent.setClassName("com.example.banknote", text);
		startActivity(intent);
	}
}
