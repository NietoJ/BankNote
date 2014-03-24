package com.example.banknote.view;

import java.util.Calendar;
import java.util.Date;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import com.example.banknote.model.DateSingle;

public class DatePickerFragment extends DialogFragment
implements DatePickerDialog.OnDateSetListener 
{
	private int year;
	private int month;
	private int day;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) 
	{
		// Use the current date as the default date in the picker
		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		// Create a new instance of DatePickerDialog and return it
		return new DatePickerDialog(getActivity(), this, year, month, day);
	}

	public void onDateSet(DatePicker view, int year, int month, int day) 
	{
		this.year = year - 1900;
		this.month = month;
		this.day = day;
		
		@SuppressWarnings("deprecation")
		Date d = new Date(this.year,this.month, this.day);
		DateSingle.getInstance().setSelectedtDate(d);
		
	}
}
