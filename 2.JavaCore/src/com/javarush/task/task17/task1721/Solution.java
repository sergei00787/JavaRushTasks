package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String file1 = reader.readLine();
		String file2 = reader.readLine();
//		String file1 = "D:/data1.txt";
//		String file2 = "D:/data2.txt";
		reader.close();

		FileInputStream fis1 = new FileInputStream(file1);
		FileInputStream fis2 = new FileInputStream(file2);
		InputStreamReader isr1 = new InputStreamReader(fis1);
		InputStreamReader isr2 = new InputStreamReader(fis2);
		BufferedReader bufReader1 = new BufferedReader(isr1);
		BufferedReader bufReader2 = new BufferedReader(isr2);

		while (bufReader1.ready()){
			allLines.add(bufReader1.readLine());
		}

		while (bufReader2.ready()){
			forRemoveLines.add(bufReader2.readLine());
		}

    	try{
    		Solution test = new Solution();
    		test.joinData();
		} catch (CorruptedDataException ex){
    		ex.printStackTrace();
		}
    }

    public void joinData() throws CorruptedDataException {

		if (allLines.containsAll(forRemoveLines)){
			allLines.removeAll(forRemoveLines);
		} else {
			allLines.clear();
			throw new CorruptedDataException();
		}

    }
}
