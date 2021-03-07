package com.javarush.task.task04.task0425;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Цель установлена!
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n1 = Integer.parseInt(reader.readLine());
		int n2 = Integer.parseInt(reader.readLine());
		
		if (n1 > 0 && n2 > 0) System.out.println(1);
		if (n1 < 0 && n2 > 0) System.out.println(2);
		if (n1 < 0 && n2 < 0) System.out.println(3);
		if (n1 > 0 && n2 < 0) System.out.println(4);
		
    }
}
