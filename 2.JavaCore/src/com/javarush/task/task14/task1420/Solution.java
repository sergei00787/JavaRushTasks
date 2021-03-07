package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			Integer num1 = Integer.parseInt(reader.readLine());
			if (num1 <= 0) throw new Exception();

			Integer num2 = Integer.parseInt(reader.readLine());
			if (num2 <= 0) throw new Exception();

			Integer divident;
			Integer divisor;

			if (num1 > num2) {
				divident = num1;
				divisor = num2;
			} else {
				divident = num2;
				divisor = num1;
			}

			Integer remainder = divident % divisor;
			if (remainder == 0) {
				System.out.println(divisor);
				return;
			}

			while (remainder > 0) {
				divident = divisor;
				divisor = remainder;
				remainder = divident % divisor;
			}

			System.out.println(divisor);
			return;


	}
}
