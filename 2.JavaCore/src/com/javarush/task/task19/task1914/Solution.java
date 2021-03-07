package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Решаем пример
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

		Pattern pattern = Pattern.compile("(\\d+) ([\\+\\-\\*]) (\\d+)");
		Matcher matcher = pattern.matcher(str);

		Integer result = 0;

		if (matcher.find()){
			if (matcher.group(2).equals("+")) {
				result = Integer.parseInt(matcher.group(1)) + Integer.parseInt(matcher.group(3));
			} else if (matcher.group(2).equals("-")){
				result = Integer.parseInt(matcher.group(1)) - Integer.parseInt(matcher.group(3));
			} else result = Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(3));
		}

    	System.out.print(str + result.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

