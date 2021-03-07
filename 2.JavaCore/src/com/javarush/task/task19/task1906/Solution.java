package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
    
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        
        int i = 1;
        while (fileReader.ready()){
            int curChar = fileReader.read();
            if (i % 2 == 0) fileWriter.write(curChar);
            i++;
        }
        
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
