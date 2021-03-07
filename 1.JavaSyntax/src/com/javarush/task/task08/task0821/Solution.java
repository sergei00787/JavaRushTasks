package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        //напишите тут ваш код
		Map<String, String> peopleMap = new HashMap<>();
		peopleMap.put("Пушкин", "Сергей");
		peopleMap.put("Гоголь", "Николай");
		peopleMap.put("Пупкин", "Василий");
		peopleMap.put("Ларин", "Иларион");
		peopleMap.put("Ленин", "Владимир");
		peopleMap.put("Сталин", "Иосиф");
		peopleMap.put("Брежнев", "Леонид");
		peopleMap.put("Никулин", "Юрий");
		peopleMap.put("Цеткин", "Роза");
		peopleMap.put("Цеткин", "Роза");

        return peopleMap;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
