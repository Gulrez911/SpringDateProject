package com.gul.main;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

public class TestClass {

	public static void main(String[] args) {
//		LocalDate todaydate = LocalDate.now();
//		System.out.println("Current Month: 	" + todaydate.getMonth());
//		System.out.println("Months first date in yyyy-mm-dd: " + todaydate.withDayOfMonth(2));
//
//		Calendar c = Calendar.getInstance(); // this takes current date
//		c.set(Calendar.DAY_OF_MONTH, 1);
//		System.out.println(c.getTime());
//		
//		  // Current date
//	      LocalDate localDate = LocalDate.now();
//	      System.out.println(localDate);

	      //Specific date
//		Month month="JANUARY";
//		month  ="Month."+month;
	      LocalDate localDate2 = LocalDate.of(2017, 8, 1);
	      System.out.println(localDate2);
	}
}
