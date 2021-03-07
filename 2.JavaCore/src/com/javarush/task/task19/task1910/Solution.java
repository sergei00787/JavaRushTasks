package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String file1 = reader.readLine();
		String file2 = reader.readLine();
//    	String file1 = "D:/data1.txt";
//    	String file2 = "D:/data2.txt";

		FileReader fileReader = new FileReader(file1);
		FileWriter fileWriter = new FileWriter(file2);
		BufferedReader bufReader = new BufferedReader(fileReader);
		BufferedWriter bufWriter = new BufferedWriter(fileWriter);

		while( bufReader.ready()){
			String str = bufReader.readLine();
			String str2 = str.replaceAll("[\\p{Punct}\\n]","");
			System.out.println(str2);
			bufWriter.write(str2);
		}
		bufWriter.flush();
		reader.close();

		bufReader.close();
		bufWriter.close();
    }
}
