package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.Scanner;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
    	BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
    	String file = consoleReader.readLine();
//    	String file = "D:/data1.txt";
    	int id = Integer.parseInt(args[0]);
//    	int id = 0;

		FileInputStream inputStream = new FileInputStream(file);
		InputStreamReader streamReader = new InputStreamReader(inputStream);
		BufferedReader reader = new BufferedReader(streamReader);

		while (reader.ready()) {
			String product = reader.readLine();
			Scanner scanner = new Scanner(product);
			if (scanner.hasNextInt()){
				int curId = scanner.nextInt();
				if (curId == id) System.out.print(product);
			}
			scanner.close();
		}

		consoleReader.close();
		inputStream.close();

    }
}
