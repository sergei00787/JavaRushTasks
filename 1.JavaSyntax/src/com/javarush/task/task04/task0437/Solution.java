package com.javarush.task.task04.task0437;

/* 
Треугольник из восьмерок
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
		int m = 10;
		for (int i = 1; i<=m; i++){
			for (int j = 1; j<=m; j++){
				System.out.print(8);
				if (i==j) break;
			}
			System.out.println("");
		}

    }
}
