package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
		ArrayList<String>[] listStrings = new ArrayList[5];
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		ArrayList<String> list3 = new ArrayList<>();
		ArrayList<String> list4 = new ArrayList<>();
		ArrayList<String> list5 = new ArrayList<>();

		list1.add("sadfoisuflaestfg");
		list2.add("dfghdfhfgnuio");
		list3.add("g,iugoryu");
		list4.add("yuiogdrty");
		list5.add("fgjuyyfty");

		listStrings[0] = list1;
		listStrings[1] = list2;
		listStrings[2] = list3;
		listStrings[3] = list4;
		listStrings[4] = list5;

        return listStrings;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String string : list) {
                System.out.println(string);
            }
        }
    }
}