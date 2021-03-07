package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* 
Прайсы
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String file = reader.readLine();
		//String file = "D:/data1.txt";
		if (args.length == 0) return;
		if (args[0].equals("-c")) addProductToTable(file, args);
	}

	public static void addProductToTable(String file, String[] args) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(file, true);

		//byte[] id = getNextIdFromFile(file).getBytes();
		//byte[] productName = appendSpacesAfter(args[1],30).getBytes();
		//byte[] price = appendSpacesAfter(args[2],8).getBytes();
		//byte[] quantity = appendSpacesAfter(args[3],4).getBytes();

		String id = String.format("%-8d", getNextIdFromFile(file));
		String productName = String.format("%-30.30s", args[1]);
		String price = String.format(Locale.ROOT, "%-8.2f", Double.parseDouble(args[2]));
		String quantity = String.format("%-4d", Integer.parseInt(args[3]));

		outputStream.write("\n".getBytes());
		outputStream.write(id.getBytes());
		outputStream.write(productName.getBytes());
		outputStream.write(price.getBytes());
		outputStream.write(quantity.getBytes());

		outputStream.close();

	}

	public static String appendSpacesAfter(String source, int countChars){
		StringBuilder sb = new StringBuilder(source);
		int countSpaceChar = countChars - source.length();
		for (int i = 0; i < countSpaceChar ; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}

	public static Integer getNextIdFromFile(String file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String curLine = "";
		Integer curId = 0;
		Integer maxId = 0;
		while (reader.ready()){
			curLine = reader.readLine();
			curId = Integer.parseInt(curLine.substring(0,8).trim());
			if (curId>maxId) maxId = curId;
		}

		Integer nextId = maxId + 1;
		reader.close();
		return nextId;
	}

}
