package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.Scanner;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		String file1 = consoleReader.readLine();
		String file2 = consoleReader.readLine();
//		String file1 = "D:/data1.txt";
//		String file2 = "D:/data2.txt";

		FileInputStream inputStream = new FileInputStream(file1);
		Scanner scanner = new Scanner(inputStream);

		FileOutputStream outputStream = new FileOutputStream(file2);

		double num = 0.0;

		while (scanner.hasNextDouble()){
			num = scanner.nextDouble();
			int intNum = (int) Math.round(num);
			String str = String.valueOf(intNum);
			outputStream.write(str.getBytes());
			outputStream.write(" ".getBytes());
		}

		outputStream.flush();
		consoleReader.close();
		inputStream.close();
		outputStream.close();
    }
}
