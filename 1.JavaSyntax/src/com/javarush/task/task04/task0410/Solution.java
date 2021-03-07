package com.javarush.task.task04.task0410;

/* 
Попадём-не-попадём
*/

public class Solution {
    public static void main(String[] args) {
        checkInterval(60);
        checkInterval(112);
        checkInterval(10);
    }

    public static void checkInterval(int number) {
        //напишите тут ваш код
        System.out.println("Число "+ number + " " + ((number>=50 && number<=100 ) ? "" : "не") + " содержится в интервале."); 
    }
}