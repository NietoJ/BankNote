package com.example.banknote.view;

import com.example.banknote.R;
import com.example.banknote.model.AccountSingle;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinancialAccountMain extends Activity {
	
	private Button btnAddTrans;
	private String text = "";
	private String displayName;
	private String balance;
	
	private TextView displayNameTV;
	private TextView balanceTV;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_financial_account_main);
		
		//displayName = AccountSingle.getCurrentAccount().getDisplayName();
		//balance =  "$ " + AccountSingle.getCurrentAccount().getBalance();
		
		displayName = "College Account";
		balance = " $ 109.00";
		
		displayNameTV = (TextView) findViewById(R.id.displayt_name_textView);
		balanceTV = (TextView) findViewById(R.id.balance_textView);
		btnAddTrans = (Button) findViewById(R.id.add_new_trans);
		
		displayNameTV.setText(String.valueOf(displayName));
		balanceTV.setText(String.valueOf(balance));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.financial_account_main, menu);
		
		btnAddTrans.setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) { 
						text = "com.example.banknote.view.AddTransScreen";
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
