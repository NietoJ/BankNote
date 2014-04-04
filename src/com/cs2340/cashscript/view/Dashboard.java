package com.cs2340.cashscript.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.cs2340.cashscript.R;
import com.cs2340.cashscript.model.UserSingle;

public class Dashboard extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    public void viewAccount(View view) {
        startActivity(new Intent(this, ViewAccount.class));
    }

    public void newAccount(View view) {
        startActivity(new Intent(this, NewAccount.class));
    }

    public void viewReport(View view) {

    }

}
