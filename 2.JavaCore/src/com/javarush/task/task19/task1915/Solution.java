package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
    	PrintStream consoleStream = System.out;
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	String file = reader.readLine();
//    	String file = "D:/data1.txt";

    	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    	PrintStream stream = new PrintStream(outputStream);
    	System.setOut(stream);

    	testString.printSomething();

    	System.setOut(consoleStream);

    	String result = outputStream.toString();

    	FileOutputStream outputStream1 = new FileOutputStream(file);
		outputStream1.write(result.getBytes());
		outputStream1.flush();
		System.out.print(result);

		reader.close();
		outputStream1.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

