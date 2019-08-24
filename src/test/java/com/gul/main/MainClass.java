package com.gul.main;

import java.text.DateFormatSymbols;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		List<Month> list = new ArrayList<Month>();
		System.out.println("...."+list);
		
		 DateFormatSymbols dfs = new DateFormatSymbols();
		 String[] arrayOfMonthsNames = dfs.getMonths();
		 for( String monthName : arrayOfMonthsNames ) { 
			 
			   System.out.println(monthName);
			 
			  }
	}
}
