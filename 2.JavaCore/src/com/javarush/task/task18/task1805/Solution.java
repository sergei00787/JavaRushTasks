package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName = reader.readLine();
		//String fileName = "D:\\data1.txt";

		FileInputStream inputStream = new FileInputStream(fileName);

		TreeSet<Integer> set = new TreeSet<Integer>();

		while (inputStream.available() > 0) {
			set.add(inputStream.read());
		}

		inputStream.close();

		for (Integer num : set) {
			System.out.print(num + " ");
		}
	}
}
