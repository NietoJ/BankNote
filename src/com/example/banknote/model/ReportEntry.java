package com.example.banknote.model;

public class ReportEntry 
{
	String category;
	double amount;
	
	public ReportEntry(String category)
	{
		this.category = category;
		this.amount = 0;	
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public double getAmount()
	{
		return amount;
	}
	
	public void addToAmount(double addition)
	{
		amount += addition;
	}
	
	public String toString()
	{
		String s = new String(category + "      " +Double.toString(amount));
		return s;
	}
	
}
