package com.example.banknote;

import com.example.banknote.model.Account;
import com.example.banknote.model.Transaction;
import com.example.banknote.model.User;
import com.example.banknote.model.addTransactionHandler;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.RadioButton;

public class AddTransScreen extends Activity {

	
	
	private String selectedType;
	private String amount;
	private boolean isIncome;
	
	private EditText amountET;
	private Spinner spinner;
	private Button btnAddTrans;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_trans_screen);
		
		spinner = (Spinner) findViewById(R.id.types_spinner);
		amountET = (EditText) findViewById(R.id.amount_text_field);
		btnAddTrans = (Button) findViewById(R.id.add_transaction_button);
		
		/*
		 * selectedType Spinner
		 */
		
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.transaction_type_array, android.R.layout.simple_spinner_item);
		
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		
		// Spinner item selection Listener  
        addListenerOnSpinnerItemSelection();
        
        /*
		 * addButton click Listener 
		 */
        btnAddTrans.setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) { // this "view" is the button
						attemptAddTrans(view);
						
					}
				});
	}


	public void addListenerOnSpinnerItemSelection() {
		// TODO Auto-generated method stub
		CustomOnItemSelectedListener selectTypeListener = new CustomOnItemSelectedListener();
		spinner.setOnItemSelectedListener(selectTypeListener);
		selectedType = selectTypeListener.getSelectedItem();
	}
	
	public void attemptAddTrans(View view) {
		// TODO Auto-generated method stub
		
		// Radio checked income / outcome
        onRadioButtonClicked(view);
 
        amount = amountET.getText().toString();
        
        //NOTICE
        //Account and User from Singleton (Now, they are null initialized objects)
        Account targetAccount = null;
        User targetUser = null;
		
		// create new transaction
        addTransactionHandler handler = new addTransactionHandler();
        handler.addNewTrans(selectedType, isIncome, amount, targetAccount, targetUser);
		
	}
	
	public void onRadioButtonClicked(View view) {
	    // Is the button now checked?
	    boolean checked = ((RadioButton) view).isChecked();
	    
	    // Check which radio button was clicked
	    switch(view.getId()) {
	        case R.id.radio_income:
	            if (checked)
	                // income are the best
	            	isIncome = true;
	            break;
	        case R.id.radio_outcome:
	            if (checked)
	                // outcome rule
	            	isIncome = false;
	            break;
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_trans_screen, menu);
		return true;
	}
	
	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

}
