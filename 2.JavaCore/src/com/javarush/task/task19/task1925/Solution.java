package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		String file1 = args[0];
		String file2 = args[1];
//		String file1 = "D:/data1.txt";
//		String file2 = "D:/data2.txt";

		FileReader fileReader = new FileReader(file1);
		FileWriter fileWriter = new FileWriter(file2);

		ArrayList<String> listWord = new ArrayList<>();
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while (bufferedReader.ready()) {
			String[] splitLine = bufferedReader.readLine().split(" ");
			for (String word : splitLine) {
				if (word.length() > 6) listWord.add(word);
			}
		}

		for (int i = 0; i < listWord.size() ; i++) {
			if (i == listWord.size()-1) {
				fileWriter.write(listWord.get(i));
			} else {
				fileWriter.write(listWord.get(i)+",");
			}
		}

		fileReader.close();
		fileWriter.close();

	}
}
