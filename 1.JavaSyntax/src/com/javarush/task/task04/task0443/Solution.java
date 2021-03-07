package com.javarush.task.task04.task0443;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Как назвали, так назвали
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		//напишите тут ваш код
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String name = bf.readLine();
		int n1 = Integer.parseInt(bf.readLine());
		int n2 = Integer.parseInt(bf.readLine());
		int n3 = Integer.parseInt(bf.readLine());

		System.out.println("Меня зовут " + name + ".");
		System.out.println("Я родился " + n3 + "." + n2 + "." + n1);

	}
}
