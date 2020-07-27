package com.gyan.Important;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalenderExp 
{
	
	public static void main(String[] args) {
		
		Calendar cal = new GregorianCalendar();
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		SimpleDateFormat sd = new SimpleDateFormat("E dd-mm-yyyy hh:mm:ss");
		// Java 1.8
		LocalDate localDate = LocalDate.now();
		
		Date date =new Date();
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH));
		System.out.println(cal.getTime());
		System.out.println(dateFormat.format(cal.getTime()));
		System.out.println(date);
		System.out.println(date.toString());
	//	System.out.println(date.getDay());
		System.out.println("date in my format:"+ sd.format(date));
		System.out.println(localDate); // only date
		System.out.println(LocalTime.now());
		System.out.println("-------");
		System.out.println(localDate.getYear());
		System.out.println(localDate.getMonth());
		System.out.println(localDate.getDayOfWeek());
		System.out.println(localDate.getDayOfMonth());


	}

}
