package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
	public static void main(String[] args) {
		//напишите тут ваш код
		Man man1 = new Man("Vasya",20,"a1");
		Man man2 = new Man("Fedya",20,"a2");
		Woman woman1 = new Woman("Toma",20,"a1");
		Woman woman2 = new Woman("Nadya",20,"a2");
		man1.print();
		man2.print();
		woman1.print();
		woman2.print();
	}

	//напишите тут ваш код
	public static class Man {
		private String name;
		private int age;
		private String address;

		public Man(String name, int age, String address){
			this.name = name;
			this.age = age;
			this.address = address;
		}

		public void print(){
			System.out.println(this.name + " " + this.age + " " + this.address);
		}
	}

	public static class Woman {
		private String name;
		private int age;
		private String address;

		public Woman(String name, int age, String address){
			this.name = name;
			this.age = age;
			this.address = address;
		}

		public void print(){
			System.out.println(this.name + " " + this.age + " " + this.address);
		}

	}
}
