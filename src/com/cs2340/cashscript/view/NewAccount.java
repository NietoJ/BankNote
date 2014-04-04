package com.cs2340.cashscript.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cs2340.cashscript.R;

public class NewAccount extends Activity {
    private EditText mFullNameView;
    private EditText mBalanceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);

        mFullNameView = (EditText) findViewById(R.id.newAccountFullName);
        mBalanceView = (EditText) findViewById(R.id.newAccountBalance);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.new_account, menu);
        return true;
    }

    public void attemptCreateAccount(View view) {
        String fullName = mFullNameView.getText().toString();
        String balance = mBalanceView.getText().toString(); // will be converted
                                                            // to double in
                                                            // NewAccountHandler
                                                            // method

        // TODO Working!
    }

}
