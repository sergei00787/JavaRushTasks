package com.javarush.task.task03.task0322;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Большая и чистая
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		String name1 = br.readLine();
		String name2 = br.readLine();
		String name3 = br.readLine();
		System.out.println(name1 + " + " + name2 + " + " + name3 + " = Чистая любовь, да-да!");
    }
}