package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException{
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	String file1 = reader.readLine();
    	String file2 = reader.readLine();
//    	String file1 = "D:/data1.txt";
//    	String file2 = "D:/data2.txt";

    	BufferedReader bufReader = new BufferedReader(new FileReader(file1));
    	BufferedWriter bufWriter = new BufferedWriter(new FileWriter(file2));

    	while (bufReader.ready()){
    		String str = bufReader.readLine();
    		String[] strArr = str.split(" ");
			for (int i = 0; i < strArr.length ; i++) {
				 try {
				 	Integer curNum = Integer.parseInt(strArr[i]);
				 	bufWriter.write(curNum.toString());
				 	bufWriter.write(" ");
					 bufWriter.flush();
				 } catch (NumberFormatException ex){

				 }
			}
		}

    	reader.close();
    	bufReader.close();
    	bufWriter.close();
    }
}
