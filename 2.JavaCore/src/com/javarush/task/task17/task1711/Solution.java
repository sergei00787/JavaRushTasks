package com.javarush.task.task17.task1711;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {
	public static volatile List<Person> allPeople = new ArrayList<Person>();

	static {
		allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
		allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
	}

	public static void main(String[] args) {
		String[] argsTile = Arrays.copyOfRange(args, 1, args.length);
		switch (args[0]) {
			case "-c":
				synchronized (allPeople) {
					createPersons(argsTile);
				}
				break;
			case "-u":
				synchronized (allPeople){
					updatePersons(argsTile);
				}
				break;

			case "-d":
				synchronized (allPeople) {
					deletePersons(argsTile);
				}
				break;

			case "-i":
				synchronized (allPeople){
					infoPersons(argsTile);
				}
				break;
		}

		// For Debug
		/*
		for (Person p: allPeople) {
			System.out.println(p.getName());
			System.out.println(p.getSex());
			System.out.println(p.getBirthDate());
		}
		*/
	}



	public static void createPersons(String[] argsCreatePersons) {
		if (argsCreatePersons.length % 3 != 0) throw new RuntimeException("Неверное количество аргуменов");
		for (int i = 0; i < argsCreatePersons.length; i = i + 3) {
			createPerson(argsCreatePersons[i], argsCreatePersons[i + 1], argsCreatePersons[i + 2]);
		}
	}

	public static void createPerson(String name, String sex, String birthDate) {
		try {
			Date bd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(birthDate);
			Person person = sex.equals("м") ? Person.createMale(name, bd) : Person.createFemale(name, bd);
			synchronized (allPeople) {
				allPeople.add(person);
				System.out.println(allPeople.size() - 1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void updatePersons(String[] argsUpdatedPersons) {
		if (argsUpdatedPersons.length % 4 != 0) throw new RuntimeException("Неверное количество аргуменов");
		for (int i = 0; i < argsUpdatedPersons.length; i = i + 4) {
			updatePerson(argsUpdatedPersons[i], argsUpdatedPersons[i + 1], argsUpdatedPersons[i + 2], argsUpdatedPersons[i + 3]);
		}
	}


	public static void updatePerson(String index, String name, String sex, String birthDate) {
		int idx = Integer.parseInt(index);

		try {
			Sex typeSex = sex.equals("м") ? Sex.MALE : Sex.FEMALE;
			Date bd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(birthDate);
			synchronized (allPeople){
				Person person = allPeople.get(idx);
				person.setName(name);
				person.setSex(typeSex);
				person.setBirthDate(bd);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void deletePersons(String[] arg) {
		for (int i = 0; i < arg.length; i++) {
			deletePerson(arg[i]);
		}
	}

	public static void deletePerson(String index) {
		int idx = Integer.parseInt(index);
		synchronized (allPeople){
			Person person = allPeople.get(idx);
			person.setName(null);
			person.setBirthDate(null);
			person.setSex(null);
		}
	}

	private static void infoPersons(String[] argsInfoPerson) {
		for (int i = 0; i < argsInfoPerson.length; i++) {
			infoPerson(argsInfoPerson[i]);
		}
	}

	public static void infoPerson(String index) {
		int idx = Integer.parseInt(index);
		synchronized (allPeople){
			Person person = allPeople.get(idx);

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
			String bd = sdf.format(person.getBirthDate());

			String sx = person.getSex().equals(Sex.MALE) ? "м" : "ж";

			System.out.println(person.getName() + " " + sx + " " + bd);
		}
	}
}
