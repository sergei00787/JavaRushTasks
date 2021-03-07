package com.javarush.task.task18.task1819;

import java.io.*;
import java.nio.charset.StandardCharsets;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String file1 = reader.readLine();
		String file2 = reader.readLine();
//    	String file1 = "D:/data1.txt";
//    	String file2 = "D:/data2.txt";

    	FileInputStream inputStream1 = new FileInputStream(file1);
    	FileInputStream inputStream2 = new FileInputStream(file2);

    	// Copy File1 to buffer
		int byteFile1 = inputStream1.available();
		byte[] buffer1 = new byte[inputStream1.available()];
    	while (inputStream1.available()>0){
    		int count = inputStream1.read(buffer1);
		}

    	// Copy File2 to buffer
		byte[] buffer2 = new byte[inputStream2.available()];
		while (inputStream2.available()>0){
			int count2 = inputStream2.read(buffer2);
		}

		// Concat both buffers
		String str = new String(buffer1, StandardCharsets.UTF_8);
		String str2 = new String(buffer2, StandardCharsets.UTF_8);
		String sumStr = str2 + str;

		FileOutputStream outputStream = new FileOutputStream(file1);
		outputStream.write(sumStr.getBytes());
		outputStream.flush();

		reader.close();
		inputStream1.close();
		inputStream2.close();
		outputStream.close();
    }
}
