package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    //напишите тут ваш код
	private String name;
	private int age;
	private String color;
	private int weight;
	private String address;

	public void initialize(String name){
		this.name = name;
		this.age = 2;
		this.color = "red";
		this.weight = 5;
	}

	public void initialize(String name, int age){
		this.name = name;
		this.age = age;
		this.color = "red";
		this.weight = 5;
	}

	public void initialize(String name, int weight, int age){
		this.name = name;
		this.age = age;
		this.color = "red";
		this.weight = weight;
	}

	public void initialize(int weight, String color){
		this.age = 2;
		this.color = color;
		this.weight = weight;
	}

	public void initialize(int weight, String color, String address){
		this.age = 2;
		this.color = color;
		this.weight = weight;
		this.address = address;
	}

}
