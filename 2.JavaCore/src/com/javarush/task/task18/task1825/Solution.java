package com.javarush.task.task18.task1825;

import java.awt.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName;
		TreeSet<String> listFiles = new TreeSet<>();

		while (!(fileName = reader.readLine()).equals("end")) {
			listFiles.add(fileName);
		}
		reader.close();
//		listFiles.add("D:/data1.txt.part1");
//		listFiles.add("D:/data1.txt.part3");
//		listFiles.add("D:/data1.txt.part2");

		FileOutputStream fileOutputStream = new FileOutputStream(listFiles.first().substring(0, listFiles.first().lastIndexOf(".part")));

		// Read files
		for (String filePathName : listFiles) {
			FileInputStream fileInputStream = new FileInputStream(filePathName);
			byte[] buffer = new byte[fileInputStream.available()];

			fileInputStream.read(buffer);
			fileOutputStream.write(buffer);

			fileInputStream.close();
		}

		fileOutputStream.close();
	}
}
