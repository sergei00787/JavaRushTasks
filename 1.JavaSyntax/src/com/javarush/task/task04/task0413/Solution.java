package com.javarush.task.task04.task0413;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
День недели
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        String str = "такого дня недели не существует";
        switch (number){
           case 1: str = "понедельник";
           break;
           case 2: str = "вторник";
           break;
           case 3: str = "среда";
           break;
           case 4: str = "четверг";
           break;
           case 5: str = "пятница";
           break;
           case 6: str = "суббота";
           break;
           case 7: str = "воскресенье";
           break;
        }
        
        System.out.println(str);
    }
}