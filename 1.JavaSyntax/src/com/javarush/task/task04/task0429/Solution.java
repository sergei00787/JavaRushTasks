package com.javarush.task.task04.task0429;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Положительные и отрицательные числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n1 = Integer.parseInt(br.readLine());
		int n2 = Integer.parseInt(br.readLine());
		int n3 = Integer.parseInt(br.readLine());
		int countPlus = 0;
		int countMinus = 0;
		if (n1>0) countPlus++;
		if (n2>0) countPlus++;
		if (n3>0) countPlus++;

		if (n1<0) countMinus++;
		if (n2<0) countMinus++;
		if (n3<0) countMinus++;
		System.out.println("количество отрицательных чисел: " + countMinus);
		System.out.println("количество положительных чисел: " + countPlus);
    }
}
