package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
		ArrayList<String> list = new ArrayList<>(5);
		list.add("asd");
		list.add("asd");
		list.add("asd");
		list.add("asd");
		list.add("asd");
		System.out.println(list.size());
		for (String s: list) {
			System.out.println(s);
		}
    }
}
