package com.cs2340.cashscript.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.cs2340.cashscript.R;

public class Welcome extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome, menu);
        return true;
    }

    public void toLogin(View view) {
        startActivity(new Intent(this, Login.class));
    }

    public void toRegister(View view) {
        startActivity(new Intent(this, Register.class));
    }
}
