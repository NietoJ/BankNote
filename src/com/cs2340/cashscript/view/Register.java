package com.cs2340.cashscript.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cs2340.cashscript.R;
import com.cs2340.cashscript.controller.RegisterHandler;

public class Register extends Activity {
    private EditText mUsernameView;
    private EditText mPassword1View;
    private EditText mPassword2View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mUsernameView = (EditText) findViewById(R.id.register_username_field);
        mPassword1View = (EditText) findViewById(R.id.register_password1_field);
        mPassword2View = (EditText) findViewById(R.id.register_password2_field);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.register, menu);
        return true;
    }

    public void attemptRegister(View view) {
        String mUsername = mUsernameView.getText().toString();
        String mPassword1 = mPassword1View.getText().toString();
        String mPassword2 = mPassword2View.getText().toString();
        Log.e("cashscript", mUsername);
        Log.e("cashscript", mPassword1);
        Log.e("cashscript", mPassword2);

        if (RegisterHandler.attemptRegister(mUsername, mPassword1, mPassword2)) {
            startActivity(new Intent(this, Login.class));
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Account cannot be created";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

}
