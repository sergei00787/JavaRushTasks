package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Cамая длинная последовательность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>(10);
		for (int i = 0; i < 10 ; i++) {
			list.add(Integer.parseInt(reader.readLine()));
		}

		int maxCount = 1;
		int currentCount = 1;
		int prevInt = list.get(0);

		for (int i = 1; i < 10 ; i++) {
			if (list.get(i) == prevInt) currentCount++;
			else {
				if(maxCount < currentCount) maxCount = currentCount;
				currentCount = 1;
			}
			prevInt = list.get(i);
		}

		if(maxCount < currentCount) maxCount = currentCount;

		System.out.println(maxCount);

    }
}
