package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Locale;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
    	private Scanner fileScanner;

		public PersonScannerAdapter(Scanner scanner) {
			this.fileScanner = scanner;
		}

		@Override
		public Person read() throws IOException, ParseException {
			Person person;
			
			String[] pers = fileScanner.nextLine().split(" ", 4);

			String firstName = pers[1];
			String middleName = pers[2];
			String lastName = pers[0];
			SimpleDateFormat sdf = new SimpleDateFormat("d M y", Locale.ENGLISH);
			Date birthDate =  sdf.parse(pers[3]);
			person = new Person(firstName, middleName, lastName, birthDate);
			return person;
		}

		@Override
		public void close() throws IOException {
			fileScanner.close();
		}
	}
}
