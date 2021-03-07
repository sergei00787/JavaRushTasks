package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
		int countWinParams = 0;
		int countEquallyParams = 0;

		if (this.age == anotherCat.age) countEquallyParams++;
		if (this.strength == anotherCat.strength) countEquallyParams++;
		if (this.weight == anotherCat.weight) countEquallyParams++;

		if (this.age > anotherCat.age) countWinParams++;
		if (this.strength > anotherCat.strength) countWinParams++;
		if (this.weight > anotherCat.weight) countWinParams++;

		if (countWinParams >=2) {
			return true;
		} else if (countWinParams == 1 && countEquallyParams ==2){
			return true;
		}
		return false;
    }

    public static void main(String[] args) {

    }
}
