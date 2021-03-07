package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[20];
		for (int i = 0; i < nums.length ; i++) {
			nums[i] = Integer.parseInt(reader.readLine());
		}

		int[] left = new int[10];
		int[] right = new int[10];

		left = Arrays.copyOfRange(nums,0,9);
		right = Arrays.copyOfRange(nums, 10,20);

		for (int i = 0; i < right.length ; i++) {
			System.out.println(right[i]);
		}


    }
}
