package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		while(!str.equals("exit")){
			if(str.contains(".")){
				try{
					Double.parseDouble(str);
					print(new Double(str));
				} catch (NumberFormatException ex){
					print(str);
				}
			}
			else {
				try {
					Integer num = Integer.parseInt(str);
					if (num > 0 && num < 128) print(new Short(str));
					else print(num);
				} catch (NumberFormatException ex) {
					print(str);
				}
			}
			str = reader.readLine();
		}
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
