package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		//напишите тут ваш код
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;

		while (true) {
			String str = buffer.readLine();
			if (str.equals("сумма")){
				System.out.println(sum);
				break;
			}
			sum += Integer.parseInt(str);
		}
	}
}
