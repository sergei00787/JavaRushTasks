package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] srtings = new String[10];
		int[] nums = new int[10];
		for (int i = 0; i < srtings.length ; i++) {
			srtings[i] = reader.readLine();
			nums[i] = srtings[i].length();
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
    }
}
