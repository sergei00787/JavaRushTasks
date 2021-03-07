package com.javarush.task.task19.task1912;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Ридер обертка 2
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
    	PrintStream consoleStream = System.out;

    	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    	PrintStream stream = new PrintStream(outputStream);

    	System.setOut(stream);

		testString.printSomething();

		String str = outputStream.toString();

		System.setOut(consoleStream);

		System.out.print(str.replaceAll("te","??"));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
