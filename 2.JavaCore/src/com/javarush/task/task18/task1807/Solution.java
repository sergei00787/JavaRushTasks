package com.javarush.task.task18.task1807;

import java.io.*;

/* 
Подсчет запятых
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String file = reader.readLine();
		//String file = "D:/data1.txt";

		FileInputStream inputStream = new FileInputStream(file);
		int count = 0;
		while (inputStream.available() > 0) {
			int intChr = inputStream.read();
			if (intChr == 44) count++;
		}
		inputStream.close();
		System.out.println(count);
	}
}
