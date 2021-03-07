package com.javarush.task.task04.task0416;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переходим дорогу вслепую
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
    	double t = Double.parseDouble(b.readLine());
    	double num = t % 5;
    	if (num < 3){
    		System.out.println("зеленый");
    	} else if (num >= 4) {
			System.out.println("красный");
		} else System.out.println("жёлтый");
    }
}