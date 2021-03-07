package com.javarush.task.task04.task0439;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Письмо счастья
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		for (int i = 1; i <= 10; i++) {
			System.out.println(name+" любит меня.");
		}
    }
}
