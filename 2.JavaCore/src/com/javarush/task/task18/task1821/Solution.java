package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
		String file = args[0];
//		String file = "D:/data1.txt";

		FileInputStream inputStream = new FileInputStream(file);

		int[] arr = new int[128];
		while (inputStream.available() > 0){
			int chrCode = inputStream.read();
			arr[chrCode]++;
		}

		for (int i = 0; i < arr.length ; i++) {
			if (arr[i] != 0) System.out.println((char)i + " " + arr[i]);
		}

		inputStream.close();

    }
}
