package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/* 
Среднее арифметическое
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		//напишите тут ваш код
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double sum = 0.0;
		int count = 0;
		while (true) {
			double number = Double.parseDouble(br.readLine());
			if (number == -1) {
				//DecimalFormat decimalFormat = new DecimalFormat( "###.#" );
				//String result = decimalFormat.format(sum / count);
				if (sum / count == 0) {
				    System.out.println("0.0");
				} else if (count == 1) { 
				    System.out.println(sum);
				} else System.out.println( sum / count);
				break;
			}
			sum += number;
			count++;
		}
	}
}

