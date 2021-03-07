package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
    	BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		FileInputStream inputStream = null;
    	while (true){
			String file = consoleReader.readLine();
			try {
				inputStream = new FileInputStream(file);
				inputStream.close();
			} catch (FileNotFoundException ex){
				System.out.print(file);
				consoleReader.close();
				//inputStream.close();
				return;
			}
		}
    }
}
