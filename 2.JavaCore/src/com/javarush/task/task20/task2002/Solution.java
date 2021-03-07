package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
	public static void main(String[] args) {
		//you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
		//вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
		try {
			File yourFile = File.createTempFile("your_file_name", null);
//			File yourFile = File.createTempFile("data1", null, new File("D:/"));
			OutputStream outputStream = new FileOutputStream(yourFile);
			InputStream inputStream = new FileInputStream(yourFile);

			JavaRush javaRush = new JavaRush();
			//initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

			/*
			User user1 = new User();
			user1.setFirstName("Sergey");
			user1.setLastName("Buymov");
			user1.setBirthDate(new Date());
			user1.setCountry(User.Country.RUSSIA);
			user1.setMale(true);
			User user2 = new User();
			javaRush.users.add(user1);
			javaRush.users.add(user2);
			*/

			javaRush.save(outputStream);
			outputStream.flush();

			JavaRush loadedObject = new JavaRush();
			loadedObject.load(inputStream);
			//here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
			for (User user : javaRush.users) {
				System.out.print( user.getFirstName() + " ");
				System.out.print( user.getLastName() + " ");
				System.out.print( user.getCountry() + " ");
				System.out.print( user.getBirthDate() + " ");
				System.out.print( user.isMale() + " ");
				System.out.println();
			}

			for (User user : loadedObject.users) {

				System.out.print( user.getFirstName() + " ");
				System.out.print( user.getLastName() + " ");
				System.out.print( user.getCountry() + " ");
				System.out.print( user.getBirthDate() + " ");
				System.out.print( user.isMale() + " ");
				System.out.println();
			}

			System.out.println(loadedObject.equals(javaRush));

			outputStream.close();
			inputStream.close();

		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Oops, something is wrong with my file");
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Oops, something is wrong with the save/load method");
			e.printStackTrace();
		}
	}

	public static class JavaRush {
		public List<User> users = new ArrayList<>();

		public void save(OutputStream outputStream) throws Exception {
			//implement this method - реализуйте этот метод
			PrintWriter writer = new PrintWriter(outputStream);
			if (users.size() != 0) {
				writer.println("usersIsNotEmpty");
				writer.println(users.size());
				for (User user : users) {
					if (Objects.isNull(user.getFirstName())) {
						writer.println("null");
					} else {
						writer.println(user.getFirstName());
					}

					if (Objects.isNull(user.getLastName())) {
						writer.println("null");
					} else {
						writer.println(user.getLastName());
					}

					if (Objects.isNull(user.getCountry())) {
						writer.println("null");
					} else {
						writer.println(user.getCountry().getDisplayName());
					}

					if (Objects.isNull(user.getBirthDate())) {
						writer.println("null");
					} else {
						Calendar calendar = new GregorianCalendar();
						calendar.setTime(user.getBirthDate());
						writer.println(calendar.getTimeInMillis());
					}

					writer.println(user.isMale());
				}
			} else {
				writer.println("usersIsEmpty");
			}
			writer.flush();
		}

		public void load(InputStream inputStream) throws Exception {
			//implement this method - реализуйте этот метод
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String userIsEmpty = reader.readLine();
			if (userIsEmpty.equals("usersIsNotEmpty")) {
				Integer countUsers = Integer.parseInt(reader.readLine());
				for (int i = 0; i < countUsers; i++) {
					User user = new User();
					String firstName = reader.readLine();
					if (!firstName.equals("null")) {
						user.setFirstName(firstName);
					}
					String lastName = reader.readLine();
					if (!lastName.equals("null")) {
						user.setLastName(lastName);
					}
					String country = reader.readLine();
					if (!country.equals("null")) {
						user.setCountry(User.Country.valueOf(country.toUpperCase()));
					}
					String strBirthDate = reader.readLine();
					if (!strBirthDate.equals("null")) {
						Long timeInMillis = Long.parseLong(strBirthDate);
						Calendar calendar = new GregorianCalendar();
						calendar.setTimeInMillis(timeInMillis);
						user.setBirthDate(calendar.getTime());
					}

					String isMale = reader.readLine();
					if (isMale.equals("true")) {
						user.setMale(true);
					} else {
						user.setMale(false);
					}

					users.add(user);
				}
			} else {
				users = new ArrayList<>();
			}
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			JavaRush javaRush = (JavaRush) o;

			return users != null ? users.equals(javaRush.users) : javaRush.users == null;

		}

		@Override
		public int hashCode() {
			return users != null ? users.hashCode() : 0;
		}
	}
}
