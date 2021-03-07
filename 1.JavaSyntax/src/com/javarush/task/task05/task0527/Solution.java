package com.javarush.task.task05.task0527;

/* 
Том и Джерри
*/

public class Solution {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);

        Dog dog = new Dog("Jack","black","WOOF");
        Cat cat = new Cat("Tom","siler","MEOW");
        //напишите тут ваш код
    }

    public static class Mouse {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    //напишите тут ваш код
	public static class Dog{
    	private String name;
    	private String color;
    	private String phrase;

    	public Dog(String name, String color, String phrase){
    		this.name = name;
    		this.phrase = phrase;
    		this.color = color;
		}
	}

	public static class Cat{
		private String name;
		private String color;
		private String phrase;

		public Cat(String name, String color, String phrase){
			this.name = name;
			this.phrase = phrase;
			this.color = color;
		}
	}
}
