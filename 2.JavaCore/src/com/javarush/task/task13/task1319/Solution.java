package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String fileName = reader.readLine();
		String currentStr = "";
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

		while (!currentStr.equals("exit")){
			currentStr = reader.readLine();
			writer.write(currentStr);
			writer.write("\n");
		}
		writer.flush();
		writer.close();
		return;
    }
}
