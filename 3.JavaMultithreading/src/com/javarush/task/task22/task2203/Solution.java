package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        try {
            int firstIndex = string.indexOf("\t");
            int secondIndex = string.indexOf("\t", firstIndex+1);
            if (firstIndex == -1 || secondIndex == -1){
                throw new TooShortStringException();
            }
                return string.substring(firstIndex+1, secondIndex);
        } catch (RuntimeException ex) {
            throw new TooShortStringException();
        }
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }

    public static class TooShortStringException extends Exception {
    }
}
