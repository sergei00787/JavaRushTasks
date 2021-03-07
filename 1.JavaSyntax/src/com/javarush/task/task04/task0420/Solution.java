package com.javarush.task.task04.task0420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

/* 
Сортировка трех чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int number1 = Integer.parseInt(reader.readLine());
		int number2 = Integer.parseInt(reader.readLine());
		int number3 = Integer.parseInt(reader.readLine());
		int[] arr = new int[]{number1, number2, number3};
		Arrays.sort(arr);
		for (int i = 2; i >= 0; i--){
			System.out.print(arr[i]+" ");
		}
    }
}
