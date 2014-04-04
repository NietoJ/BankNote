package com.cs2340.cashscript.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cs2340.cashscript.R;
import com.cs2340.cashscript.controller.LoginHandler;

public class Login extends Activity {
    private EditText mUsernameView;
    private EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsernameView = (EditText) findViewById(R.id.loginUsername);
        mPasswordView = (EditText) findViewById(R.id.loginPassword);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    public void attemptLogin(View view) {
        // get strings from views
        String username = mUsernameView.getText().toString();
        String password = mPasswordView.getText().toString();

        if (LoginHandler.attemptLogin(username, password)) {
            startActivity(new Intent(this, Dashboard.class));
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Login failed. Try again!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}
