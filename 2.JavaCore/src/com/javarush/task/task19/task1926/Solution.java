package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
    	BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
    	String file = consoleReader.readLine();
//    	String file = "D:/data1.txt";
		consoleReader.close();

    	FileReader fileReader = new FileReader(file);
    	BufferedReader bufferedReader = new BufferedReader(fileReader);

    	while(bufferedReader.ready()){
    		String line = bufferedReader.readLine();
    		String[] chrsLine = line.split("");
			for (int i = chrsLine.length-1; i >= 0  ; i--) {
				System.out.print(chrsLine[i]);
			}
			System.out.println();
		}

    	bufferedReader.close();
    }
}
