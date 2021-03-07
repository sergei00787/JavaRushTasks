package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String file = reader.readLine();
			if (file.equals("exit")) break;
			ReadThread readThread = new ReadThread(file);
			readThread.start();
		}

		reader.close();
		/*
		for (int Bt: resultMap.values()) {
			System.out.println(Bt);
		}
		*/
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            //implement constructor body
			putMaxMatchByte(fileName);
        }

		// implement file reading here - реализуйте чтение из файла тут
        private synchronized void putMaxMatchByte(String fileName){
			try {
				FileReader reader = new FileReader(fileName);
				int[] simbols = new int[65536];
				while (reader.ready()){
					int curByte = reader.read();
					simbols[curByte]++;
				}

				int maxCount = 0;
				int maxByte = 0;
				for (int i = 0; i < simbols.length; i++) {
					if (simbols[i] > maxCount){
						maxCount = simbols[i];
						maxByte = i;
					}
				}

				Solution.resultMap.put(fileName, maxByte);
				reader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

    }
}
