package com.example.banknote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.example.banknote.model.LoginHandler;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class Login_screen extends Activity {

	// Values for email and password at the time of the login attempt.
	private String mEmail;
	private String mPassword;

	// UI references.
	private EditText mEmailView;
	private EditText mPasswordView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login_screen);

		// Set up the login form.
		mEmailView = (EditText) findViewById(R.id.email);
		mPasswordView = (EditText) findViewById(R.id.password);

		findViewById(R.id.sign_in_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						attemptLogin(view);
					}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.login_screen, menu);
		return true;
	}

	/**
	 * Attempts to sign in the account specified by the login form.
	 */
	public void attemptLogin(View view) {

		// Store values at the time of the login attempt.
		mEmail = mEmailView.getText().toString();
		mPassword = mPasswordView.getText().toString();
		
		boolean loginSuccess = LoginHandler.attemptLogin(mEmail, mPassword); 
		if(loginSuccess){
			Intent successIntent = new Intent();
			successIntent.setClassName("com.example.banknote", "com.example.banknote.LoginSuccess");
			startActivity(successIntent); 
		} 
	}


}