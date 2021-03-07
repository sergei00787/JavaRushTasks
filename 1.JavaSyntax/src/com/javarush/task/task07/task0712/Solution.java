package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> strings = new ArrayList<>();
		int max = 0;
		int min = 1000000;
		String curStr;
		for (int i = 0; i < 10; i++) {
			curStr = reader.readLine();
			strings.add(curStr);
			if (curStr.length() > max) max = curStr.length();
			if (curStr.length() < min) min = curStr.length();
		}

		for (int i = 0; i < strings.size() ; i++) {
			if (strings.get(i).length() == min || strings.get(i).length() == max) {
				System.out.println(strings.get(i));
				break;
			}
		}
    }
}
