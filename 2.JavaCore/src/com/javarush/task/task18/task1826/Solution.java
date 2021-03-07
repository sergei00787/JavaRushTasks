package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка

Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName - имя файла, который необходимо зашифровать/расшифровать.
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования.
-e - ключ указывает, что необходимо зашифровать данные.
-d - ключ указывает, что необходимо расшифровать данные.

-e D:\data1.txt D:\data2.txt
-d D:\data2.txt D:\data3.txt
*/

public class Solution {
    public static void main(String[] args) throws IOException {
    	switch (args[0]){
			case "-e":
				encrypt(args[1], args[2]);
				break;
			case "-d":
				decrypt(args[1], args[2]);
				break;
		}
    }

    public static void  encrypt(String source, String destination) throws IOException {
    	FileInputStream fileInputStream = new FileInputStream(source);
    	FileOutputStream fileOutputStream = new FileOutputStream(destination);

    	while (fileInputStream.available() > 0){
    		int currentChar = fileInputStream.read();
    		fileOutputStream.write(currentChar+1);
		}
    	fileInputStream.close();
    	fileOutputStream.close();
	}

	public static void  decrypt(String source, String destination) throws IOException{
		FileInputStream fileInputStream = new FileInputStream(source);
		FileOutputStream fileOutputStream = new FileOutputStream(destination);

		while (fileInputStream.available() > 0){
			int currentChar = fileInputStream.read();
			fileOutputStream.write(currentChar-1);
		}
		fileInputStream.close();
		fileOutputStream.close();
	}

}
