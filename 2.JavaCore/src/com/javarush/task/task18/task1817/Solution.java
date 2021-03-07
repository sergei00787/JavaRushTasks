package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//		String file = "D:/data1.txt";
		String file = args[0].toString();
		FileInputStream inputStream = new FileInputStream(file);

		double countChars = 0.00;
		int countSpaceChar = 0;
    	while (inputStream.available() > 0) {
    		int curByte = inputStream.read();
    		countChars++;
    		if (Character.isSpaceChar(curByte)) countSpaceChar++;
		}

    	double result = (countSpaceChar / countChars * 100);
    	System.out.print(String.format("%.2f", result));
		inputStream.close();
    }
}
