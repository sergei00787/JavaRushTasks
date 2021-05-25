package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
	public static void main(String... args) throws IOException {

		String fileName = args[0];
//		String fileName = "D:/test/data2.txt";
		long number = Long.parseLong(args[1]);
//		long number = 0;
		String text = args[2];
//		String text = "data2";

		RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
		raf.seek(number);
		byte[] buffer = new byte[text.length()];
		raf.read(buffer, 0, text.length());

		String readingText = new String(buffer);
		System.out.println(readingText);
		String result = "false";
		if (readingText.equals(text)) {
			result = "true";
		} else {
			result = "false";
		}
		raf.seek(raf.length());
		raf.write(result.getBytes());

		raf.close();
	}
}
