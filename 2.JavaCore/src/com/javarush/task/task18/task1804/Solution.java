package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые редкие байты
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName = reader.readLine();
		FileInputStream inputStream = new FileInputStream(fileName);

		//Map для хранения байтов и их количества
		HashMap<Integer, Integer> mapByte = new HashMap<>();
		Integer currentByte;
		Integer currentValue;

		while (inputStream.available() > 0) {
			currentByte = inputStream.read();
			if (!mapByte.containsKey(currentByte)) {
				mapByte.put(currentByte,1);
			} else {
				currentValue = mapByte.get(currentByte);
				mapByte.replace(currentByte, ++currentValue);
			}
		}

		inputStream.close();

		Integer minCountByte = Integer.MAX_VALUE;

		Collection<Integer> listCount = mapByte.values();
		for (Integer c: listCount) {
			if (c < minCountByte) minCountByte = c;
		}

		for (Map.Entry entry : mapByte.entrySet()) {
			if (entry.getValue() == minCountByte) System.out.print(entry.getKey() + " ");
		}

	}
}
