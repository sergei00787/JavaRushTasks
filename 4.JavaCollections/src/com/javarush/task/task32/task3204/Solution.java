package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/

public class Solution {
	public static void main(String[] args) {
		ByteArrayOutputStream password = getPassword();
		System.out.println(password.toString());
	}

	public static ByteArrayOutputStream getPassword() {
		ByteArrayOutputStream result = new ByteArrayOutputStream();

		char[] arrNums = new char[10];
		for (int i = 48; i < 58; i++) {
			arrNums[i - 48] = (char) i;
		}

		char[] arrUpChars = new char[26];
		for (int i = 65; i < 91; i++) {
			arrUpChars[i - 65] = (char) i;
		}

		char[] arrDownChars = new char[26];
		for (int i = 97; i < 123; i++) {
			arrDownChars[i - 97] = (char) i;
		}

		final int COUNT_CHARS = 8;

		int countNums = (int) Math.round(Math.random() * ((COUNT_CHARS-1) / 2));
		if (countNums == 0) {
			countNums++;
		}

		int countUpChars = (int) Math.round(Math.random() * ((COUNT_CHARS-1) - countNums));
		if (countUpChars == 0) {
			countUpChars++;
		}

		char[] chrs = new char[COUNT_CHARS];

		for (int i = 0; i < countNums; i++) {
			int position = (int) (Math.random() * COUNT_CHARS);
			if (chrs[position] == 0) {
				chrs[position] = (char) arrNums[(int) (Math.random() * arrNums.length)];
			} else {
				countNums++;
			}
		}

		for (int i = 0; i < countUpChars; i++) {
			int position = (int) (Math.random() * COUNT_CHARS);
			if (chrs[position] == 0) {
				chrs[position] = (char) arrUpChars[(int) (Math.random() * arrUpChars.length)];
			} else {
				countUpChars++;
			}
		}

		for (int i = 0; i < chrs.length ; i++) {
			if (chrs[i] == 0) {
				chrs[i] = (char) arrDownChars[(int) (Math.random() * arrDownChars.length)];
			}
		}

		for (int i = 0; i < chrs.length ; i++) {
			result.write(chrs[i]);
		}

		return result;
	}
}
