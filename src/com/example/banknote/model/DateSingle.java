package com.example.banknote.model;

import java.util.Date;



public class DateSingle 
{
	private Date startDate;
	private Date endDate;
	private Date selectedDate;
	
	private DateSingle(){}
	
	private static class SingletonHolder
	{
		private static final DateSingle INSTANCE = new DateSingle();
	}
	
	public static DateSingle getInstance()
	{
		return SingletonHolder.INSTANCE;
	}
	
	public Date getStartDate()
	{
		return startDate;
	}
	
	public void setSelectedtDate(Date date)
	{
		if (selectedDate == startDate)
		{
			startDate = date;
		}
		if (selectedDate == endDate)
		{
			endDate = date;
		}
		
	
	}
	
	public Date getEndDate()
	{
		return endDate;
	}
	

	
	public void selectStartDate()
	{
		startDate = selectedDate;
	}
	public void selectEndDate()
	{
		endDate = selectedDate;
	}
}