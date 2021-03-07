package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Файл в статическом блоке
*/

public class Solution {
	public static List<String> lines = new ArrayList<String>();

	static 
	{
		FileReader fileReader;
		try {
			fileReader = new FileReader(Statics.FILE_NAME);
			BufferedReader br = new BufferedReader(fileReader);
			while (br.ready()){
				String str = br.readLine();
				//System.out.println(str);
				lines.add(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


		public static void main (String[]args){
			System.out.println(lines);
		}
	}
