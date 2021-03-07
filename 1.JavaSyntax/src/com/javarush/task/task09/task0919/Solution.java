package com.javarush.task.task09.task0919;

/* 
Деление на ноль
*/

public class Solution {

    public static void main(String[] args) {
		try {
			divideByZero();
		}
		catch (RuntimeException e){

			e.printStackTrace();
		}

    }

    public static void divideByZero() throws ArithmeticException{
			int num = 10 / 0;
			System.out.println(num);
	}

}
