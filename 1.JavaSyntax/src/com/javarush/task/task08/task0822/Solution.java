package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        // Найти минимум тут
		int min = array.get(0);
		for (int i=0; i< array.size();i++){
			if (array.get(i) < min) min=array.get(i);
		}
		return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        // Создать и заполнить список тут
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(reader.readLine());

		List<Integer> list = new ArrayList<Integer>();
		int i = 0;
		while (i<num){
			list.add(Integer.parseInt(reader.readLine()));
			i++;
		}
        return list;
    }
}
