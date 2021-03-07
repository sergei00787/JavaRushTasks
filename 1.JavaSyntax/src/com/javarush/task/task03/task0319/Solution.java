package com.javarush.task.task03.task0319;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Предсказание на будущее
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
		InputStreamReader inputStream = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStream);

		String name = bufferedReader.readLine();
		String num1 = bufferedReader.readLine();
		String num2 = bufferedReader.readLine();

		System.out.println(name + " получает " + num1 + " через " + num2 + " лет.");

    }
}
