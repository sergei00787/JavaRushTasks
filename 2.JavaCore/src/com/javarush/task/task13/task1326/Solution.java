package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		// напишите тут ваш код
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String file = reader.readLine();
		//String file = "D:\\data2.txt";

		FileInputStream fileInputStream = new FileInputStream(file);
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

		int num;
		String curStr = "";
		Integer curNum;
		StringBuilder stringBuilder = new StringBuilder();
		ArrayList<Integer> arrNum = new ArrayList<Integer>(10);

		Predicate<Integer> isOdd = a -> (a % 2) == 0;

		while ((num = bufferedInputStream.read()) != -1) {
			Character chr = (char) num;
			if (num != 10) {
				stringBuilder.append(chr);
			} else {
				curStr = stringBuilder.toString();
				curNum = Integer.parseInt(curStr);
				stringBuilder.setLength(0);
				arrNum.add(curNum);
			}
		}
		curStr = stringBuilder.toString();
		curNum = Integer.parseInt(curStr);
		stringBuilder.setLength(0);
		arrNum.add(curNum);

		List<Integer> result = arrNum.stream().filter(isOdd).collect(Collectors.toList());
		Comparator<Integer> comp = (a, b) -> a > b ? 1 : -1;

		result.sort(comp);

		for (Integer i: result) {
			System.out.println(i);
		}

		fileInputStream.close();

	}
}
