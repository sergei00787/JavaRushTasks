package com.javarush.task.task04.task0422;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
18+
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String name = reader.readLine();
		int age = Integer.parseInt(reader.readLine());
		if (age < 18) System.out.println("Подрасти еще");
    }
}
