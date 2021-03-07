package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = new String[10];
		for (int i = 0; i <= 7  ; i++) {
			arr[i] = reader.readLine();
		}


		for (int i = 0; i < arr.length ; i++) {
			System.out.println(arr[9-i]);
		}
    }
}