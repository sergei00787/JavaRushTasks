package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
	public static Map<String, String> createMap() {
		//напишите тут ваш код
		Map<String, String> map = new HashMap<>();
		map.put("1", "Валя");
		map.put("2", "Федя");
		map.put("3", "Маша");
		map.put("4", "Маша");
		map.put("5", "Миша");
		map.put("6", "Маша");
		map.put("7", "Валя");
		map.put("8", "Гриша");
		map.put("9", "Надя");
		map.put("10", "Толя");

		return map;
	}

	public static void removeTheFirstNameDuplicates(Map<String, String> map) {
		//напишите тут ваш код
		Set<String> set = new HashSet<>();
		for (String name : map.values()) {
			if (countNameInList(map.values(), name) > 1) set.add(name);
		}

		for (String name : set) {
			removeItemFromMapByValue(map, name);
		}


	}

	public static int countNameInList(Collection<String> arr, String name) {
		int result = 0;
		for (String currName : arr) {
			if (currName == name) result++;
		}
		return result;
	}

	public static void removeItemFromMapByValue(Map<String, String> map, String value) {
		Map<String, String> copy = new HashMap<>(map);
		for (Map.Entry<String, String> pair : copy.entrySet()) {
			if (pair.getValue().equals(value)) {
				map.remove(pair.getKey());
			}
		}
	}

	public static void main(String[] args) {
		/*
		Map<String, String> map = createMap();
		removeTheFirstNameDuplicates(map);
		for (Map.Entry<String, String> pair : map.entrySet()) {
			System.out.println(pair.getKey() + " - " + pair.getValue());
		}
*/
	}
}
