package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
    	String file1 = args[0];
    	String file2 = args[1];
//    	String file1 = "D:/data1.txt";
//    	String file2 = "D:/data2.txt";

    	FileReader fileReader = new FileReader(file1);
    	FileWriter fileWriter = new FileWriter(file2);

    	StringBuilder sb = new StringBuilder();
    	BufferedReader bufferedReader = new BufferedReader(fileReader);
    	while(bufferedReader.ready()){
    		sb.append(bufferedReader.readLine());
		}
    	bufferedReader.close();

		String[] words = sb.toString().split(" ");

		for (String word: words ) {
			if (word.matches("(.*)[0-9]+(.*)")){
				fileWriter.write(word + " ");
				//System.out.print(word + " ");
			}
		}

		fileWriter.close();
    }
}
