package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int m = Integer.parseInt(reader.readLine());

		ArrayList<String> list = new ArrayList<>(n);


		for (int i = 0; i < n; i++) {
			String str = reader.readLine();
			list.add(str);
		}

		for (int i = 0; i < m ; i++) {
			String delStr = list.remove(0);
			list.add(delStr);
		}

		for (String str: list) {
			System.out.println(str);
		}
        //напишите тут ваш код
    }
}
