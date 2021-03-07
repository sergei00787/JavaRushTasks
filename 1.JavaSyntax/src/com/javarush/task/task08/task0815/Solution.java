package com.javarush.task.task08.task0815;

import java.util.*;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
		Map<String,String> map = new HashMap<>();

		map.put("Соболев","Иван");
		map.put("Петросян","Влад");
		map.put("Кукуев","Коля");
		map.put("Петров","Вася");
		map.put("Иванов","Иван");
		map.put("Сидоров","Иван");
		map.put("Смирнов","Иван");
		map.put("Спиридонов","Иван");
		map.put("Бунин","Федя");
		map.put("Толстой","Лев");

		return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
		int result = 0;
		Collection<String> arr =  map.values();
		for (String fName: arr) {
			if (fName.equals(name)) result++;
		}
		return result;

    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
		int result = 0;
		Set<String> set = map.keySet();
		for (String lstName: set) {
			if (lstName.equals(lastName)) result++;
		}
		return result;



    }

    public static void main(String[] args) {
    	/*
		Map<String,String> map = createMap();
    	int i1 = getCountTheSameFirstName(map,"Петров");
		int i2 = getCountTheSameLastName(map,"Иван");
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(map.size());
*/
    }
}
