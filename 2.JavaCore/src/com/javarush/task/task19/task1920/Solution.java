package com.javarush.task.task19.task1920;

import java.io.*;
import java.util.*;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException {
    	String file = args[0];
//    	String file = "D:/data1.txt";
    	
    	FileReader fileReader = new FileReader(file);
    	BufferedReader reader = new BufferedReader(fileReader);

		TreeMap<String, Double> map = new TreeMap<>();
    	
    	while (reader.ready()){
    		String[] salaryRow = reader.readLine().split(" ");
    		String name = salaryRow[0];
    		Double salary = Double.parseDouble(salaryRow[1]);
    		if (map.containsKey(name)) {
    			map.replace(name, map.get(name) + salary);
			} else {
    			map.put(name, salary);
			}
		}

		reader.close();

    	Collection<Double> listSalary = map.values();
    	Double maxSalary = Collections.max(listSalary);

		for (Map.Entry<String, Double> salaryEntry: map.entrySet()) {
			if (salaryEntry.getValue().equals(maxSalary)){
				System.out.println(salaryEntry.getKey());
			}
		}

    }
}
