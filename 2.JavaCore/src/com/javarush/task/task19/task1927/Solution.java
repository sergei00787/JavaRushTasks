package com.javarush.task.task19.task1927;

import java.io.*;

/* 
Контекстная реклама
*/

public class Solution {
	public static TestString testString = new TestString();
	public static int countCall = 1;

	public static void main(String[] args) throws IOException {
		PrintStream consoleOutStream = System.out;

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(outputStream);

		System.setOut(stream);

		testString.printSomething();

		String[] result = outputStream.toString().split("\n");

		System.setOut(consoleOutStream);

		String text = "JavaRush - курсы Java онлайн";
		for (int i = 0; i < result.length; i++) {
			if (countCall == 2) {
				System.out.println(result[i] + System.lineSeparator() + text);
				countCall = 1;
			} else {
				System.out.println(result[i]);
				countCall++;
			}
		}

	}

	public static class TestString {
		public void printSomething() {
			System.out.println("first");
			System.out.println("second");
			System.out.println("third");
			System.out.println("fourth");
			System.out.println("fifth");
		}
	}
}
