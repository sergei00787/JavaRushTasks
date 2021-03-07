package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 
Статические коты
*/

public class Cat {
    //напишите тут ваш код
	public static ArrayList<Cat> cats;

    public Cat() {
    }

    public static void main(String[] args) {
        //напишите тут ваш код
		cats = new ArrayList<Cat>();
		for (int i = 1; i <= 10 ; i++) {
			Cat cat = new Cat();
			Cat.cats.add(cat);
		}
		printCats();
    }

    public static void printCats() {
        //напишите тут ваш код
		for (Cat cat: cats) {
			System.out.println(cat);
		}
    }
}
