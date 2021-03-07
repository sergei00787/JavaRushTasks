package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	String file = reader.readLine();
    	//String file = "D:/data1.txt";

    	FileReader fileReader = new FileReader(file);
    	StringBuilder stringBuilder = new StringBuilder();

    	while(fileReader.ready()){
    		stringBuilder.append(Character.toChars(fileReader.read()));
		}
		String str = stringBuilder.toString();
		String[] words = str.split("\\s?[\\W]\\s?");
		//Pattern pattern = "\\W?world\\W?";

		int count = 0;
		for (int i = 0; i < words.length ; i++) {
			if ("world".equals(words[i])) count++;
		}
    	System.out.println(count);
		reader.close();
		fileReader.close();
    }
}
