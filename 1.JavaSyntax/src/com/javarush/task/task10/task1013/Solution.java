package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

import java.time.LocalDate;

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
		private String firstName;
		private String lastName;
		private int age;
		private String sex;
		private LocalDate birthday = LocalDate.now();
		private int weight;

		public Human(){
		}
		
		public Human(String firstName){
			this.firstName = firstName;
		}

		public Human(int age){
			this.age = age;
		}

		public Human(String firstName, String lastName){
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public Human(int age, int weight){
			this.age = age;
			this.weight = weight;
		}

		public Human(int age, int weight, LocalDate birthday){
			this.age = age;
			this.weight = weight;
			this.birthday = birthday;
		}



		public Human(String firstName, String lastName, int age){
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
		}

		public Human(String firstName, String lastName, int age, String sex){
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
			this.sex = sex;
		}

		public Human(String firstName, String lastName, int age, String sex, LocalDate birthday){
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
			this.sex = sex;
			this.birthday = birthday;
		}

		public Human(String firstName, String lastName, int age, String sex, LocalDate birthday, int weight){
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
			this.sex = sex;
			this.birthday = birthday;
			this.weight = weight;
		}
    }
}
