package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		StringWriter writer = getAllDataFromInputStream(new FileInputStream("D:/test/data2.txt"));
		System.out.println(writer.toString());
	}

	public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
		StringWriter stringWriter = new StringWriter();
		if (is == null) return stringWriter;

		try(BufferedReader reader = new BufferedReader(new InputStreamReader(is))){
			while (reader.ready()) {
				stringWriter.write(reader.readLine());
			}
			if (stringWriter.toString().equals(null)) stringWriter.write("");
			return stringWriter;
		} catch (FileNotFoundException ex) {
			stringWriter.write("");
			return new StringWriter();
		} catch (IOException ioex) {
			stringWriter.write("");
			return new StringWriter();
		}

	}
}
