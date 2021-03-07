package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	String file1 = reader.readLine();
    	String file2 = reader.readLine();
    	String file3 = reader.readLine();
//    	String file1 = "D:/data1.txt";
//    	String file2 = "D:/data2.txt";
//    	String file3 = "D:/data3.txt";

    	FileOutputStream outputStream = new FileOutputStream(file1,true);
    	FileInputStream inputStream1 = new FileInputStream(file2);
    	FileInputStream inputStream2 = new FileInputStream(file3);

    	while (inputStream1.available()>0){
    		outputStream.write(inputStream1.read());
		}
//    	outputStream.write("\n".getBytes());

    	while (inputStream2.available()>0){
    		outputStream.write(inputStream2.read());
		}

    	reader.close();
    	outputStream.close();
    	inputStream1.close();
    	inputStream2.close();
    }
}
