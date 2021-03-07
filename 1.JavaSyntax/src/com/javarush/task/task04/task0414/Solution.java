package com.javarush.task.task04.task0414;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Количество дней в году
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String year = br.readLine();
        
        int dayInYear = 0;
        int numYear = Integer.parseInt(year);

        if (numYear % 400 == 0) {
            dayInYear = 366;
        } else if (numYear % 400 % 100 == 0) {
            dayInYear = 365;
        } else if (numYear % 400 % 100 % 4 == 0){
            dayInYear = 366;
        } else dayInYear = 365;
        
        System.out.println("количество дней в году: " + dayInYear);
    }
}