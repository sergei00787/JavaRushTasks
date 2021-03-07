package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
    	String file = args[0];
//		String file = "D:/data1.txt";

		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while (bufferedReader.ready()){
			Person person = parsePersonString(bufferedReader.readLine());
			PEOPLE.add(person);
		}

		bufferedReader.close();

    }

    public static Person parsePersonString(String personString) throws ParseException {
    	Person person = null;
    	String[] personArrString = personString.split(" ");

    	StringBuilder sbName = new StringBuilder();
		StringBuilder sbBirthDate = new StringBuilder();

		for (int i = 0; i < personArrString.length ; i++) {
			if (personArrString[i].matches("[a-zA-Zа-яА-Я\\-]+")) {
				sbName.append(personArrString[i] + " ");
			} else {
				sbBirthDate.append(personArrString[i] + " ");
			}
		}

		String name = sbName.toString().trim();
		String birthDateStr = sbBirthDate.toString().trim().replaceAll(" ", ".");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
		Date birthDate = simpleDateFormat.parse(birthDateStr);

		person = new Person(name, birthDate);

//    	System.out.println(name);
//		System.out.println(birthDate.toString());

    	return person;
	}

}
