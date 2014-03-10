package com.example.banknote.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

/**
 * Get the value of spinner when user select one listed item
 * @author Nghia Huynh
 *
 */

public class CustomOnItemSelectedListener implements OnItemSelectedListener {

	private String selectedItem;
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long id) {
		// TODO Auto-generated method stub
		selectedItem = parent.getItemAtPosition(pos).toString();
		
		//Toast.makeText(parent.getContext(), 
        //        "On Item Select : \n" + parent.getItemAtPosition(pos).toString(),
        //        Toast.LENGTH_LONG).show();

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}

}
