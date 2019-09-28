package com.gul.main3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateClas {

	public static void main(String[] args) throws ParseException {
		String start_dt = "2019-01-31";

		DateFormat parser = new SimpleDateFormat("yyyy-MM-dd"); 
		Date date = (Date) parser.parse(start_dt);
		System.out.println("Date Format: "+date);
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
		System.out.println(formatter.format(date));
		Student student = new Student();
		student.setDob(date);
		System.out.println("student: "+student.getDob());
		
		
	}
}
