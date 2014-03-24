package com.example.banknote.model;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reports {
	
//	private List<Transaction> temp = UserSingle.getCurrentUser()
	
	public static List<Transaction> foodAndDrink;  
	public static List<Transaction> shopping;  
	public static List<Transaction> bills;  
	public static List<Transaction> entertainment;  
	public static List<Transaction> familyAndPersonal;  
	public static List<Transaction> home;  
	public static List<Transaction> utilities;  
	public static List<Transaction> car;  
	public static List<Transaction> travel;  
	public static List<Transaction> others;  
	
	
	static Date dateFrom; 
	static Date dateTo; 
	
	public static void storeDate(Date date1, Date date2) {
		dateFrom = date1; 
		dateTo = date2; 
	}
	
	@SuppressWarnings("deprecation")
	public static List<Transaction> getDateRange(List<Transaction> fullList) { 
		List<Transaction> dateRange = new ArrayList<Transaction>(); 
		for (Transaction t: fullList) {
			if (t.getRecordedTime().after(dateFrom) && 
					t.getRecordedTime().before(dateTo)) {
				dateRange.add(t);
			}
		}
//		int i = 0; 
//		List<Transaction> dateRange = new ArrayList<Transaction>(); 
//		Transaction temp = fullList.get(i); 
//		Date currDate = temp.getRecordedTime(); 
//		boolean found = false; 
//		while(found == false) {
//			//if dateFrom equals the currDate in the transaction list 
//			if(dateFrom.compareTo(currDate) == 0) {
//				dateRange.add(temp); 
//				while(dateFrom.compareTo(currDate) == 0) {
//					i++; 
//					temp = fullList.get(i); 
//					if(temp == null)
//					{
//						break; 
//					}
//					if(dateTo.compareTo(currDate) == 0) {
//						dateRange.add(temp); 
//						found = true; 
//					}
//				}
//			}
//			else {
//				i++; 
//				temp = fullList.get(i); 
//			}
	//	}
		
//		while(found == false)
//		{
//			temp = fullList.get(i); 
//			@SuppressWarnings("deprecation")
//			int year = currDate.getYear(); 
//			int month = currDate.getMonth(); 
//			int day = currDate.getDay(); 
//			if(year == dateFrom.getYear() && month == dateFrom.getMonth() && day == dateFrom.getDay())
//			{
//				dateRange.add(temp); 
//				while()
//			}
//			else{
//				i++; 
//			}
//		}
		return dateRange;//dateRange; 
	}
	
	public static List<Transaction> getFullList() { 
		//get list of accounts
		ArrayList<Account> accounts = UserSingle.getCurrentUser().getAccounts(); 
		//actual list of transactions for each account
		List<Transaction> fullList = null; 
		//gets list of all the histories of each account 
		for(int i = 0; i<accounts.size(); i++) 
		{
			Account current = accounts.get(i); 
			//gets arraylist transactions
			fullList.addAll(current.getHistory().getArrayList()); 
		}
		//now i got a full list of all the transactions, sort them 
		return fullList; 
	}
	
	//check for dates that would end up that day 
	//check for dates apart 
	//check for dates negative 
	public static ArrayList<String> spendingCategoryReport(List<Transaction> dateRange) { 
		ArrayList<String> report = null; 
		Transaction currTransanction; 		
		for(int i = 0; i<dateRange.size(); i++) {
			currTransanction = dateRange.get(i); 
			String currType = currTransanction.getType(); 
			if(currType == "Food and Drink") {
				foodAndDrink.add(currTransanction); 
			}
			else if(currType == "Shopping") { 
				shopping.add(currTransanction); 
			}
			else if(currType == "Bills") { 
				bills.add(currTransanction); 

			}
			else if(currType == "Entertainment") { 
				entertainment.add(currTransanction); 

			}
			else if(currType == "Family And Personal") { 
				familyAndPersonal.add(currTransanction); 

			}
			else if(currType == "Home") { 
				home.add(currTransanction); 

			}
			else if(currType == "Utilities") { 
				utilities.add(currTransanction); 

			}
			else if(currType == "Car") { 
				car.add(currTransanction); 

			}
			else if(currType == "Travel") { 
				travel.add(currTransanction); 

			}
			else if(currType == "Others") { 
				others.add(currTransanction); 
			}
		}
		
		report.add(getFoodAndDrinkTotal(foodAndDrink)); 
		report.add(getFoodAndDrinkTotal(shopping)); 
		report.add(getFoodAndDrinkTotal(bills)); 
		report.add(getFoodAndDrinkTotal(entertainment)); 
		report.add(getFoodAndDrinkTotal(familyAndPersonal)); 
		report.add(getFoodAndDrinkTotal(home)); 
		report.add(getFoodAndDrinkTotal(utilities)); 
		report.add(getFoodAndDrinkTotal(car)); 
		report.add(getFoodAndDrinkTotal(travel)); 
		report.add(getFoodAndDrinkTotal(others)); 
		return report; 
	}
	
	
	public static String getFoodAndDrinkTotal(List<Transaction> foodAndDrink) {
		double sum = 0; 
		for(int i = 0; i<foodAndDrink.size(); i++) {
			Transaction curr = foodAndDrink.get(i); 
			sum = sum + curr.getAmount(); 
		}
		return "Food And Drink" + Double.toString(sum); 
	}
	
	public static String getShoppingTotal(List<Transaction> shopping) {
		double sum = 0; 
		for(int i = 0; i<shopping.size(); i++) {
			Transaction curr = shopping.get(i); 
			sum = sum + curr.getAmount(); 
		}
		return "Shopping" + Double.toString(sum); 
	}
	
	public static String getBillsTotal(List<Transaction> bills) {
		double sum = 0; 
		for(int i = 0; i<bills.size(); i++) {
			Transaction curr = bills.get(i); 
			sum = sum + curr.getAmount(); 
		}
		return "Bills" + Double.toString(sum); 
	}
	
	public static String getEntertainmentTotal(List<Transaction> entertainment) {
		double sum = 0; 
		for(int i = 0; i<entertainment.size(); i++) {
			Transaction curr = entertainment.get(i); 
			sum = sum + curr.getAmount(); 
		}
		return "Entertainment" + Double.toString(sum); 
	}
	
	public static String getFamilyAndPersonalTotal(List<Transaction> familyAndPersonal) {
		double sum = 0; 
		for(int i = 0; i<familyAndPersonal.size(); i++) {
			Transaction curr = familyAndPersonal.get(i); 
			sum = sum + curr.getAmount(); 
		}
		return "Family And Personal" + Double.toString(sum); 
	}
	
	public static String getHomeTotal(List<Transaction> home) {
		double sum = 0; 
		for(int i = 0; i<home.size(); i++) {
			Transaction curr = home.get(i); 
			sum = sum + curr.getAmount(); 
		}
		return "Home" + Double.toString(sum); 
	}
	
	public static String getUtilitiesTotal(List<Transaction> utilities) {
		double sum = 0; 
		for(int i = 0; i<utilities.size(); i++) {
			Transaction curr = utilities.get(i); 
			sum = sum + curr.getAmount(); 
		}
		return "Utilities" + Double.toString(sum); 
	}
	
	public static String getCarTotal(List<Transaction> car) {
		double sum = 0; 
		for(int i = 0; i<car.size(); i++) {
			Transaction curr = car.get(i); 
			sum = sum + curr.getAmount(); 
		}
		return "Car" + Double.toString(sum); 
	}
	
	public static String getTravelTotal(List<Transaction> travel) {
		double sum = 0; 
		for(int i = 0; i<travel.size(); i++) {
			Transaction curr = travel.get(i); 
			sum = sum + curr.getAmount(); 
		}
		return "Travel" + Double.toString(sum); 
	}
	
	public static String getOthersTotal(List<Transaction> others) {
		double sum = 0; 
		for(int i = 0; i<others.size(); i++) {
			Transaction curr = others.get(i); 
			sum = sum + curr.getAmount(); 
		}
		return "Others" + Double.toString(sum); 
	}

	
	//getters
	
	public static List<Transaction> getFoodAndDrink(List<Transaction> foodAndDrink) {
		return foodAndDrink; 
	}
	
	public static List<Transaction> getShopping(List<Transaction> shopping) {
		return shopping; 
	}
	
	public static List<Transaction> getBills(List<Transaction> bills) {
		return bills; 
	}
	
	public static List<Transaction> getEntertainment(List<Transaction> entertainment) {
		return entertainment; 
	}
	
	public static List<Transaction> getFamilyAndPersonal(List<Transaction> familyAndPersonal) {
		return familyAndPersonal; 
	}
	
	public static List<Transaction> getHome(List<Transaction> home) {
		return home; 
	}
	
	public static List<Transaction> getUtilities(List<Transaction> utilities) {
		return utilities; 
	}
	
	public static List<Transaction> getCar(List<Transaction> car) {
		return car; 
	}
	
	public static List<Transaction> getTravel(List<Transaction> travel) {
		return travel; 
	}
	
	public static List<Transaction> getOthers(List<Transaction> others) {
		return others; 
	}

	public static ArrayList<String> getReports(Date start, Date end) {
		// TODO Auto-generated method stub
		storeDate(start, end);
		return spendingCategoryReport(getDateRange(getFullList())); 

	}
}



