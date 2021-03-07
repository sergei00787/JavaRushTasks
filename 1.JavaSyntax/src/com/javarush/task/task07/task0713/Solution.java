package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        
        for(int i = 0; i < 20; i++){
            int num = Integer.parseInt(reader.readLine()); 
            list.add(num);
            if (num % 3 == 0) list1.add(num);
            if (num % 2 == 0) list2.add(num);
            if (num % 2 != 0 && num % 3 != 0) list3.add(num);
        }
        
        printList(list1);
        printList(list2);
        printList(list3);
    }

    public static void printList(ArrayList<Integer> list) {
        //напишите тут ваш код
        for(int i=0; i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
