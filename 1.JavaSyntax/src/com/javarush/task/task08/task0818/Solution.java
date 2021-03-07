package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
		Map<String,Integer> map = new HashMap<>();
		map.put("1", 500);
		map.put("2", 100);
		map.put("3", 50);
		map.put("4", 1500);
		map.put("5", 2500);
		map.put("6", 3500);
		map.put("7", 4500);
		map.put("8", 5500);
		map.put("9", 6500);
		map.put("10", 0);
		return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код
		Map<String,Integer> copyMap = new HashMap<>(map);
		for (Map.Entry<String,Integer> pair: copyMap.entrySet()) {
			if (pair.getValue() < 500) map.remove(pair.getKey());
		}
    }

    public static void main(String[] args) {
		/*
    	Map<String,Integer> map = createMap();
		removeItemFromMap(map);
		for (String name: map.keySet()) {
			System.out.println(name);
		}
		*/
    }
}