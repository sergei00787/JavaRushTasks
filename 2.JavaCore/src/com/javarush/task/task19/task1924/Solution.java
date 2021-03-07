package com.javarush.task.task19.task1924;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
	public static Map<Integer, String> map = new HashMap<Integer, String>();

	static {
		map.put(0, "ноль");
		map.put(1, "один");
		map.put(2, "два");
		map.put(3, "три");
		map.put(4, "четыре");
		map.put(5, "пять");
		map.put(6, "шесть");
		map.put(7, "семь");
		map.put(8, "восемь");
		map.put(9, "девять");
		map.put(10, "десять");
		map.put(11, "одиннадцать");
		map.put(12, "двенадцать");
	}

	public static void main(String[] args) {
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

		String file = null;
		try {
			file = consoleReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}


//		String file = "D:/data1.txt";
		try {
			consoleReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}

		while (true) {
			try {
				if (!reader.ready()) break;
			} catch (IOException e) {
				e.printStackTrace();
			}

			String line = null;
			try {
				line = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String[] lineSplit = line.split(" ");

			StringBuilder sbLine = new StringBuilder();
			for (String word : lineSplit) {
				if (word.matches("\\b[0-9]+\\b")){
					Integer curNumber = Integer.parseInt(word);
					if (curNumber >= 0 && curNumber <= 12) {
						sbLine.append(map.get(curNumber)+" ");
					} else {
						sbLine.append(curNumber+" ");
					}
				} else {
					sbLine.append(word+" ");
				}
			}

			System.out.println(sbLine.toString().trim());
		}

		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
