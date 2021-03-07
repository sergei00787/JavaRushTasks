package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	String fileName = reader.readLine();
		FileInputStream inputStream = new FileInputStream(fileName);

		int currentByte;
		int maxByte = 0;
		while (inputStream.available() > 0){
			 currentByte = inputStream.read();
			 if (currentByte > maxByte) maxByte = currentByte;
		}
		inputStream.close();

		System.out.println(maxByte);

    }
}
