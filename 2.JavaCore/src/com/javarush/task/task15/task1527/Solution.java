package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* 
Парсер реквестов
*/

public class Solution {
	public static void main(String[] args) {
		//add your code here
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			URI uri = new URI(reader.readLine());
			ArrayList<String> listKeys = new ArrayList<>();
			ArrayList<String> listValues = new ArrayList<>();

			String strQuery = uri.getQuery();
			String[] params = strQuery.split("&");

			for (int i = 0; i < params.length; i++) {
				if (params[i].contains("=")) {
					String[] pair = params[i].split("=");
					listKeys.add(pair[0]);
					if (pair[0].equals("obj")) {
						listValues.add(pair[1]);
					}
				} else {
					listKeys.add(params[i]);
				}
			}

			for (String key : listKeys) {
				System.out.print(key + " ");
			}

			System.out.println();

			for (String value : listValues) {
				try {
					Double dblValue = Double.parseDouble(value);
					alert(dblValue);
				} catch (NumberFormatException nfEx) {
					alert(value);
				}

			}

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void alert(double value) {
		System.out.println("double: " + value);
	}

	public static void alert(String value) {
		System.out.println("String: " + value);
	}
}
