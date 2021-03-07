package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		//напишите тут ваш код
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[15];
		int evenPeople = 0;
		int oddPeople = 0;

		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(reader.readLine());
			if (i % 2 == 0)
				evenPeople += nums[i];
			else
				oddPeople += nums[i];
		}

		if (evenPeople > oddPeople) System.out.println("В домах с четными номерами проживает больше жителей.");
		else System.out.println("В домах с нечетными номерами проживает больше жителей.");
	}
}
