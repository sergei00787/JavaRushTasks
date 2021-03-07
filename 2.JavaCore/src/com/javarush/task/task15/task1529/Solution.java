package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
	public static void main(String[] args) {

	}

	static {
		//add your code here - добавьте код тут
		try {
			reset();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static CanFly result;

	public static void reset() throws IOException {
		//add your code here - добавьте код тут
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(inputStreamReader);
		String paramFly = reader.readLine();
		if (paramFly.equals("helicopter")) {
			result = new Helicopter();
		}
		if (paramFly.equals("plane")) {
			int countPass = Integer.parseInt(reader.readLine());
			result = new Plane(countPass);
		}
		reader.close();
	}
}
