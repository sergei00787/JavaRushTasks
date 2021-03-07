package com.javarush.task.task04.task0442;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Суммирование
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		//напишите тут ваш код
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		while (true) {
			int n1 = Integer.parseInt(bf.readLine());
			if (n1 == -1) {
				sum += n1;
				System.out.println(sum);
				break;
			}
			sum += n1;
		}

	}
}
