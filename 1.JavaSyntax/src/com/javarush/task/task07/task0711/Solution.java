package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> strings = new ArrayList<String>();

		for (int i = 0; i < 5 ; i++) {
			String string = reader.readLine();
			strings.add(string);
		}

		for (int i = 0; i < 13; i++) {
			String delStr = strings.remove(strings.size()-1);
			strings.add(0, delStr);
		}

		for (int i = 0; i < strings.size() ; i++) {
			System.out.println(strings.get(i));
		}


    }
}
