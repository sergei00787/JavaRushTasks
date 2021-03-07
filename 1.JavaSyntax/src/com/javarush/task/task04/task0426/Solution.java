package com.javarush.task.task04.task0426;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Ярлыки и числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
		//напишите тут ваш код
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int number1 = Integer.parseInt(reader.readLine());
		if (number1 == 0){
			System.out.println("ноль");
		} else {
			String strPlus = (number1 > 0) ? "положительное" : "отрицательное";
			String odd = (number1 % 2 == 0) ? "четное" : "нечетное";
			System.out.printf("%s %s число", strPlus, odd);
		}
    }
}
