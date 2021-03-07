package com.javarush.task.task07.task0721;

//import sun.security.mscapi.CPublicKey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

        //напишите тут ваш код
		try {
			int[] arr = getInts();

			maximum = arr[0];
			minimum = arr[0];

			for (int num: arr) {
				if (num > maximum) maximum = num;
				if (num < minimum) minimum = num;
			}

			System.out.print(maximum + " " + minimum);
		} catch (Exception e){
			System.out.println("Error"+e.getMessage());
			throw new IOException(e);
		}


    }

    //напишите тут ваш код
	public static int[] getInts(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	int[] arr = new int[20];
    	try {
			for (int i = 0; i < 20 ; i++) {
				int num = Integer.parseInt(reader.readLine());
				arr[i] = num;
			}
		} catch (IOException exception) {
    		System.out.println();
		}
		return arr;
	}
}
