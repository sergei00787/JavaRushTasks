package com.javarush.task.task06.task0606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Чётные и нечётные циферки
*/

public class Solution {

	public static int even;
	public static int odd;

	public static void main(String[] args) throws IOException {
		//напишите тут ваш код
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String strCount = reader.readLine();
		int number;
		String[] arrNumber = strCount.split("");

		for (int i = 0; i < arrNumber.length; i++) {
			//System.out.println(arrNumber[i]);
			number = Integer.parseInt(arrNumber[i]);
			if (number % 2 == 0) {
				even++;
			} else {
				odd++;
			}
		}
		System.out.println("Even: " + even + " Odd: " + odd);
	}
}
