package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {

    	System.out.println(isDateOdd("MAY 1 2013"));
    	//System.out.println(isDateOdd("JANUARY 2 2021"));
    }

    public static boolean isDateOdd(String date) {

		SimpleDateFormat formatter = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);

		try{
			Date date1 = formatter.parse(date);
			Calendar calendar = new GregorianCalendar();
			calendar.set(Calendar.MONTH, date1.getMonth());
			calendar.set(Calendar.DATE, date1.getDate());
			calendar.set(Calendar.YEAR, date1.getYear());
			int day_of_year = calendar.get(Calendar.DAY_OF_YEAR);
			if (day_of_year % 2 == 0) return false;
		}
		catch (ParseException e){
			e.printStackTrace();
		}

    	return true;
    }
}
