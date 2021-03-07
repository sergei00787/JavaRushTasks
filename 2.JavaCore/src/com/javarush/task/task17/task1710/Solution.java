package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
	public static List<Person> allPeople = new ArrayList<Person>();

	static {
		allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
		allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
	}

	public static void main(String[] args) {
		switch (args[0]) {
			case "-c":
				createPerson(args[1], args[2], args[3]);
				break;

			case "-u":
				updatePerson(args[1], args[2], args[3], args[4]);
				break;

			case "-d":
				deletePerson(args[1]);
				break;

			case "-i":
				infoPerson(args[1]);
				break;
		}
/*
		for (Person p: allPeople) {
			System.out.println(p.getName());
			System.out.println(p.getSex());
			System.out.println(p.getBirthDate());
		}*/
	}

	public static void createPerson(String name, String sex, String birthDate) {
		try {
			Date bd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(birthDate);
			Person person = sex.equals("м") ? Person.createMale(name, bd) : Person.createFemale(name, bd);
			allPeople.add(person);
			System.out.println(allPeople.size() - 1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void updatePerson(String index, String name, String sex, String birthDate) {
		int idx = Integer.parseInt(index);
		Sex typeSex = sex.equals("м") ? Sex.MALE : Sex.FEMALE;
		try {
			Date bd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(birthDate);
			Person person = allPeople.get(idx);
			person.setName(name);
			person.setSex(typeSex);
			person.setBirthDate(bd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void deletePerson(String index){
		int idx = Integer.parseInt(index);
		Person person = allPeople.get(idx);
		person.setName(null);
		person.setBirthDate(null);
		person.setSex(null);
	}

	public static void infoPerson(String index){
		int idx = Integer.parseInt(index);
		Person person = allPeople.get(idx);

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
		String bd = sdf.format(person.getBirthDate());

		String sx = person.getSex().equals(Sex.MALE) ? "м" : "ж";

		System.out.println(person.getName() + " " + sx + " " + bd);
	}


}
