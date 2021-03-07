package com.javarush.task.task10.task1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* 
Функциональности маловато!
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		HashMap<String, Integer> map = new HashMap<>();

		String intStr;
		String name;

		while (true) {
			intStr = reader.readLine();
			if (intStr.equals("")) break;
			name = reader.readLine();
			if (intStr.equals("")) break;
			int id = Integer.parseInt(intStr);
			map.put(name, id);
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.print(entry.getValue() + " " + entry.getKey());
			System.out.println();
		}


	}
}
