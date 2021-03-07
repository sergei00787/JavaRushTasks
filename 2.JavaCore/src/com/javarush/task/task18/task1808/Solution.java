package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String file1 = reader.readLine();
		String file2 = reader.readLine();
		String file3 = reader.readLine();

		//String file1 = "D:/data1.txt";
		//String file2 = "D:/data2.txt";
		//String file3 = "D:/data3.txt";

		FileInputStream inputStream = new FileInputStream(file1);
		FileOutputStream outputStream1 = new FileOutputStream(file2);
		FileOutputStream outputStream2 = new FileOutputStream(file3);


		int countByte = inputStream.available();
		int readByte;
		if (countByte % 2 != 0) {
			readByte = countByte / 2 + 1;
		} else {
			readByte = countByte / 2;
		}
		byte[] buffer = new byte[readByte];
		int iter = 1;
		while (inputStream.available() > 0){
			int count = inputStream.read(buffer);
			if ( iter == 1 ){
				outputStream1.write(buffer, 0, count);
			} else {
				outputStream2.write(buffer, 0, count);
			}
			iter++;
		}

		inputStream.close();
		outputStream1.close();
		outputStream2.close();
	}
}
