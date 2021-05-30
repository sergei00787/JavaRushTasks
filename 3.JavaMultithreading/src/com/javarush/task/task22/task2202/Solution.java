package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
        System.out.println(getPartOfString("Амиго и "));

    }

    public static String getPartOfString(String string) {
        try {
            String[] arrWords = string.split(" ");
            if (arrWords.length< 5){
                throw new TooShortStringException();
            }
            String[] newArr = Arrays.copyOfRange(arrWords, 1, 5);
            String result = String.join(" ", newArr);
            return result;
        } catch (RuntimeException ex) {
            throw new TooShortStringException();
        }

    }

    public static class TooShortStringException extends RuntimeException {
    }
}
