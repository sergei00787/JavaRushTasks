package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/

public class Solution {

	public static Map<String, String> runtimeStorage = new HashMap<>();

	public static void save(OutputStream outputStream) throws Exception {
		//напишите тут ваш код
		Properties properties = new Properties();
		properties.putAll(runtimeStorage);
		properties.store(outputStream, "");
		/*
		PrintWriter writer = new PrintWriter(outputStream);
		for (Map.Entry<String, String> entry : runtimeStorage.entrySet()) {
			writer.println(entry.getKey() + " = " + entry.getValue());
		}
		writer.flush();
		*/
	}

	public static void load(InputStream inputStream) throws IOException {
		//напишите тут ваш код
		Properties props = new Properties();
		props.load(inputStream);

		HashMap<String, String> hm = new HashMap<>();
		props.forEach((k, v) -> hm.put((String) k, (String) v));

		runtimeStorage.putAll(hm);
	}

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//			 FileInputStream fos = new FileInputStream(reader.readLine())
			 FileInputStream fos = new FileInputStream("D:/data1.properties");
			 FileOutputStream fs = new FileOutputStream("D:/data2.properties")
		) {
			load(fos);
			save(fs);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(runtimeStorage);
	}
}

