package com.javarush.task.task18.task1816;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {

		FileReader fileReader = new FileReader(args[0].toString());
//		FileReader fileReader = new FileReader("D:/data1.txt");

		BufferedReader reader = new BufferedReader(fileReader);

		String curLine="";
		int count = 0;
		while (reader.ready()){
			curLine = reader.readLine();
			String[] arrStr = curLine.split("");
			for (int i = 0; i < arrStr.length; i++) {
				if (arrStr[i].matches("[a-zA-Z]")) count++;
			}
		}
		System.out.print(count);

		fileReader.close();
    }
}
