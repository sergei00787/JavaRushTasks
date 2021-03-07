package com.javarush.task.task19.task1919;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
		String file = args[0];
//		String file = "D:/data1.txt";

    	FileReader fileReader = new FileReader(file);
    	BufferedReader bufferedReader = new BufferedReader(fileReader);

		TreeMap<String, Double> mapSalary = new TreeMap<String, Double>();

    	while(bufferedReader.ready()) {
    		String[] arr = bufferedReader.readLine().split(" ");
    		if (mapSalary.containsKey(arr[0])) {
    			mapSalary.replace(arr[0], mapSalary.get(arr[0]) + Double.parseDouble(arr[1]));
			} else {
    			mapSalary.put(arr[0], Double.parseDouble(arr[1]));
			}
		}

		bufferedReader.close();

		for (Map.Entry<String, Double> entrySalary: mapSalary.entrySet()) {
			System.out.println(entrySalary.getKey()+" " + entrySalary.getValue());
		}
    }
}
