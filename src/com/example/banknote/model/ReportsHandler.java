

package com.example.banknote.model;

import java.util.Date;

public class ReportsHandler {

	public static void addDateFromAndTo(Date date1, Date date2) {
		Reports.storeDate(date1, date2); 
	}
}
