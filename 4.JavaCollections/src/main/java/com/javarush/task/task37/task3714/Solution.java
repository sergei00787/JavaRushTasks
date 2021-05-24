package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Древний Рим
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        String[] strings = s.split("");
        int result = 0;
        for (int i = strings.length-1; i >= 0; i--) {
            if (i > 0 && letterToInt(strings[i]) > letterToInt(strings[i - 1])) {
                result = result + letterToInt(strings[i]) - 2 * letterToInt(strings[i - 1]);
            } else {
                result = result + letterToInt(strings[i]);
            }
        }
        return result;

    }

    public static int letterToInt(String letter) {
        int result;
        switch (letter) {
            case "I":
                result = 1;
            break;
            case "V":
                result = 5;
            break;
            case "X":
                result = 10;
            break;
            case "L":
                result = 50;
            break;
            case "C":
                result = 100;
            break;
            case "D":
                result = 500;
            break;
            case "M":
                result = 1000;
            break;
            default:
                result = 0;
        }
        return result;
    }
}
