package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
	public static List<String> words = new ArrayList<String>();

	static {
		words.add("файл");
		words.add("вид");
		words.add("В");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String file = reader.readLine();
//		String file = "D:/data1.txt";
		reader.close();

		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while (bufferedReader.ready()) {
			String curString = bufferedReader.readLine();
			String[] curWordsSplit = curString.split(" ");
			ArrayList<String> wordsInLine = new ArrayList<>();
			for (String word : curWordsSplit) {
				wordsInLine.add(word);
			}

			int countWordInLine = 0;
			for (String word : words) {
				if (wordsInLine.contains(word)) countWordInLine++;
			}
			if (countWordInLine == 2) System.out.println(curString);
		}

		bufferedReader.close();
	}
}
