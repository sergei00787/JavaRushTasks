package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам Ӏ Java Syntax: 9 уровень, 11 лекция
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> list = new ArrayList<>();
		String line = reader.readLine();
		while (!line.isEmpty()) {
			list.add(line);
			line = reader.readLine();
		}

		String[] array = list.toArray(new String[0]);
		sort(array);

		for (String x : array) {
			System.out.println(x);
		}
	}

	public static void sort(String[] array) {
		// напишите тут ваш код
		String[] copy = array.clone();
		int a, b;
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < copy.length; j++) {
				if (isNumber(array[i])) {
					a = Integer.parseInt(array[i]);
					if (isNumber(copy[j])) {
						b = Integer.parseInt(array[j]);
						if (a < b) {
							array[i] = copy[j];
							array[j] = copy[i];
							copy[j] = copy[i];
							copy[i] = array[i];
						}
					}
				} else {
					if (!isNumber(copy[j])){
						if (isGreaterThan(array[i], array[j])) {
							array[i] = copy[j];
							array[j] = copy[i];
							copy[j] = copy[i];
							copy[i] = array[i];
						}
					}
				}
			}

		}
	}

	// Метод для сравнения строк: 'а' больше чем 'b'
	public static boolean isGreaterThan(String a, String b) {
		return a.compareTo(b) > 0;
	}


	// Переданная строка - это число?
	public static boolean isNumber(String text) {
		if (text.length() == 0) {
			return false;
		}

		char[] chars = text.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char character = chars[i];

			// есть '-' внутри строки
			if (i != 0 && character == '-') {
				return false;
			}

			// не цифра и не начинается с '-'
			if (!Character.isDigit(character) && character != '-') {
				return false;
			}

			// одиночный '-'
			if (chars.length == 1 && character == '-') {
				return false;
			}
		}

		return true;
	}
}
