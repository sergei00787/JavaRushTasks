package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
	//напишите тут ваш код
	private String name;
	private String address;
	private String color;
	private int age;
	private int weight;

	public Cat(String name) {
		this.name = name;
		this.color = "red";
		this.age = 5;
		this.weight = 5;
	}

	public Cat(String name, int weight, int age) {
		this.name = name;
		this.color = "red";
		this.age = age;
		this.weight = weight;
	}

	public Cat(int weight, String color) {
		this.color = color;
		this.age = 5;
		this.weight = weight;
	}

	public Cat(String name, int age) {
		this.name = name;
		this.color = "red";
		this.age = age;
		this.weight = 5;
	}

	public Cat(int weight, String color, String address) {
		this.color = color;
		this.age = 5;
		this.weight = weight;
		this.address = address;
	}

	public static void main(String[] args) {

	}
}
