package com.cs2340.cashscript.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.cs2340.cashscript.R;

public class ViewAccount extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_account);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.view_account, menu);
        return true;
    }

}
