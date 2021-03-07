package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			while(true){
				list.add(Integer.parseInt(reader.readLine()));
			}
		}
		catch (IOException e){
			for (int num: list) {
				System.out.println(num);
			}
		}
		catch (NumberFormatException e){
			for (int num: list) {
				System.out.println(num);
			}
		}
    }
}
