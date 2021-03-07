package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws IOException {
    	String fileName = args[0];
//		String fileName = "D:/test/data2.txt";
    	long number = Long.parseLong(args[1]);
//    	long number = 500;
    	String text = args[2];
//    	String text = "test test test test test test test test test ";

    	RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
    	if (raf.length() < number) number = raf.length();
    	raf.seek(number);
    	raf.write(text.getBytes());
    }
}
