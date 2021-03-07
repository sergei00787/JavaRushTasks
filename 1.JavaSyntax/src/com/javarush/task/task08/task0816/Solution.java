package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Смирнов", dateFormat.parse("MAY 1 2012"));
        map.put("1", dateFormat.parse("JUNE 1 2012"));
        map.put("2", dateFormat.parse("JULY 1 2012"));
        map.put("3", dateFormat.parse("AUGUST 1 2012"));
        map.put("4", dateFormat.parse("MAY 1 2012"));
        map.put("5", dateFormat.parse("MAY 1 2012"));
        map.put("6", dateFormat.parse("MAY 1 2012"));
        map.put("7", dateFormat.parse("MAY 1 2012"));
        map.put("8", dateFormat.parse("MAY 1 2012"));
        map.put("9", dateFormat.parse("MAY 1 2012"));

        return map;
        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
		Set<String> set = new HashSet<>();
		for (Map.Entry<String, Date> pair: map.entrySet()) {
			Date curDate = pair.getValue();
			if (curDate.getMonth() == 5 || curDate.getMonth() == 6 || curDate.getMonth() == 7) set.add(pair.getKey());
		}

		for (String lastName: set){
			map.remove(lastName);
		}

    }

    public static void main(String[] args) {

    }
}
