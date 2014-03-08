package com.example.banknote;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class FinancialAccountMain extends Activity {
	
	private Button btnAddTrans;
	private String text = "";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_financial_account_main);
		
		btnAddTrans = (Button) findViewById(R.id.add_new_trans);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.financial_account_main, menu);
		
		btnAddTrans.setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) { 
						text = "com.example.banknote.AddTransScreen";
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
