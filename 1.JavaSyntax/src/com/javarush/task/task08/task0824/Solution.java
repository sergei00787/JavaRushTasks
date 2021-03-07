package com.javarush.task.task08.task0824;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
	public static void main(String[] args) {
		//напишите тут ваш код
		Human son1 = new Human("Pasha", true, 12, new ArrayList<>());
		Human dota1 = new Human("Vera", false, 12, new ArrayList<>());
		Human son2 = new Human("Ivan", true, 15, new ArrayList<>());
		Human[] child1 = {son1, dota1, son2};
		Human father = new Human("Slava", true, 38, new ArrayList<>(Arrays.asList(child1)));
		Human mother = new Human("Marya", true, 35, new ArrayList<>(Arrays.asList(child1)));
		Human[] child2 = {father};
		Human[] child3 = {mother};

		Human grmother1 = new Human("Marya", true, 65, new ArrayList<>(Arrays.asList(child2)));
		Human grmother2 = new Human("Liza", true, 80, new ArrayList<>(Arrays.asList(child2)));
		Human grfather1 = new Human("Stepa", true, 65, new ArrayList<>(Arrays.asList(child3)));
		Human grfather2 = new Human("Petr", true, 80, new ArrayList<>(Arrays.asList(child3)));

		System.out.println(son1.toString());
		System.out.println(dota1.toString());
		System.out.println(son2.toString());
		System.out.println(father.toString());
		System.out.println(mother.toString());
		System.out.println(grmother1.toString());
		System.out.println(grfather1.toString());
		System.out.println(grmother2.toString());
		System.out.println(grfather2.toString());
	}

	public static class Human {
		//напишите тут ваш код
		String name;
		boolean sex;
		int age;
		ArrayList<Human> children;

		public Human(String name, boolean sex, int age, ArrayList<Human> childs) {
			this.name = name;
			this.sex = sex;
			this.age = age;
			this.children = childs;
		}

		public String toString() {

			String text = "";
			text += "Имя: " + this.name;
			text += ", пол: " + (this.sex ? "мужской" : "женский");
			text += ", возраст: " + this.age;

			int childCount = this.children.size();
			if (childCount > 0) {
				text += ", дети: " + this.children.get(0).name;

				for (int i = 1; i < childCount; i++) {
					Human child = this.children.get(i);
					text += ", " + child.name;
				}
			}
			return text;
		}
	}
}
