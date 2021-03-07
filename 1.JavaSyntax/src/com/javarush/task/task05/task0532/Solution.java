package com.javarush.task.task05.task0532;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Задача по алгоритмам Ӏ Java Syntax: 5 уровень, 12 лекция
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = 0;

        int n = Integer.parseInt(reader.readLine());

        if (n <= 0) return;

        int m = 0;
        for (int i=1; i<= n; i++){
        	if (i==1){
        		maximum = Integer.parseInt(reader.readLine());
			} else {
        		m = Integer.parseInt(reader.readLine());
        		if (m >= maximum) maximum = m;
			}
		}
        //напишите тут ваш код

        System.out.println(maximum);
    }
}
