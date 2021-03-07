package com.javarush.task.task15.task1514;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static
	{
//    labels = new TreeMap<>();
//    labels = new LinkedHashMap<>();
//    labels = new ConcurrentHashMap<>();
//    labels = new WeakHashMap<>();
//    labels = new ConcurrentSkipListMap<>();
		labels.put(1.0, "asd");
		labels.put(2.0, "asd");
		labels.put(3.0, "asd");
		labels.put(4.0, "asd");
		labels.put(5.0, "asd");
	}

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
