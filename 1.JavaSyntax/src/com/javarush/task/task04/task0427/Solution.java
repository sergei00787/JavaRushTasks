package com.javarush.task.task04.task0427;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Описываем числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n1 = Integer.parseInt(br.readLine());
		//int n1 = 0;
		if (n1 < 1 || n1 > 999) return;
		String odd = (n1 % 2 == 0)? "четное ": "нечетное ";
		String ch="однозначное";
		if (n1 / 10 > 0) ch = "двузначное";
		if (n1 / 100 > 0) ch = "трехзначное";
		System.out.println(odd+ch+" число");
    }
}
