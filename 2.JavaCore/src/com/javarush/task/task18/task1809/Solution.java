package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String file1 = reader.readLine();
		String file2 = reader.readLine();

		//String file1 = "D:/data1.txt";
		//String file2 = "D:/data2.txt";

		FileInputStream inputStream= new FileInputStream(file1);
		FileOutputStream outputStream = new FileOutputStream(file2);

		byte[] buffer = new byte[inputStream.available()];
		int count = inputStream.read(buffer,0, inputStream.available());

		byte temp = 0;
		for (int i = 0; i < buffer.length / 2; i++) {
			temp = buffer[i];
			buffer[i]=buffer[buffer.length-i-1];
			buffer[buffer.length-i-1] = temp;
		}

		outputStream.write(buffer,0, count);

		inputStream.close();
		outputStream.close();
    }
}
