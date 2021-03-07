package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        double dollar = convertEurToUsd(5000, 1.25);
        System.out.println(dollar);
        dollar = convertEurToUsd(6000, 1.25);
        System.out.println(dollar);
    }

    public static double convertEurToUsd(int eur, double exchangeRate) {
        //напишите тут ваш код
        double dollar = eur * exchangeRate;
        return dollar;
        
    }
}
