package com.example.banknote.view;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.banknote.R;
import com.example.banknote.model.DateSingle;

public class SelectDateActivity extends FragmentActivity
{
	Button reportButton;
	Button startButton;
	Button endButton;
	int startId = 0;
	int endId = 1;
	TextView displayStart;
	TextView displayEnd;
	
	boolean startSet = false;
	boolean endSet = false;
//For next step
//	ListView listView;
//	ListAdapter listAdapter;
	
	 public void onCreate(Bundle savedInstanceState) 
	 {
	 
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_reports_screen);
	        
	        displayStart = (TextView) findViewById(R.id.displayStart);
	        displayEnd = (TextView) findViewById(R.id.displayEnd);

	        reportButton = (Button) findViewById(R.id.get_report_button);
			reportButton.setOnClickListener(new OnClickListener()
			{
				public void onClick(View v)
				{
					
					if (DateSingle.getInstance().getStartDate() == null || DateSingle.getInstance().getEndDate() == null )
					{
						String message = "Must select at least one date";
						Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
						toast.setGravity(Gravity.CENTER, 0, 0);
						toast.show();
					}
					else// (dates are set)
					{
						displayStart.setText(DateSingle.getInstance().getStartDate().toString());
						displayEnd.setText(DateSingle.getInstance().getEndDate().toString());
					//	displayListVeiw();
					}	
				}
			});
	        
	        startButton = (Button) findViewById(R.id.button_startDate);
			startButton.setOnClickListener(new OnClickListener()
			{
				public void onClick(View v)
				{
					DateSingle.getInstance().selectStartDate();
					showDatePickerDialog(v);
				}
			});
			
	        endButton = (Button) findViewById(R.id.button_endDate);
			endButton.setOnClickListener(new OnClickListener()
			{
				public void onClick(View v)
				{
					DateSingle.getInstance().selectEndDate();
					showDatePickerDialog(v);
				}
			});
	        
	 }
//	 protected void displayListVeiw() 
//	 {
//		 listView = (ListView) findViewById(R.id.listView1);
//
//			
//		listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
//		listView.setAdapter(listAdapter);
//		
//        listView.setOnItemClickListener(new OnItemClickListener() 
//        {
//        	@Override
//            public void onItemClick(AdapterView<?> parent, View view,
//              int position, long id) 
//        	
//              
//             // ListView Clicked item index
//             int itemPosition     = position;
//             
//             // ListView Clicked item value
//             String  itemValue    = (String) listView.getItemAtPosition(position);
//                
//              // Show Alert 
//              Toast.makeText(getApplicationContext(),
//                "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
//                .show();
	           
	       
		
	
	public void showDatePickerDialog(View v) 
	 {
		    DialogFragment newFragment = new DatePickerFragment();
		    newFragment.show(getSupportFragmentManager(), "datePicker");
	 }
}
