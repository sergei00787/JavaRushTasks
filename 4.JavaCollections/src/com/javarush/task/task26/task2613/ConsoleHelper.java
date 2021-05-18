package com.javarush.task.task26.task2613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));


    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
        try {
            return bis.readLine().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String askCurrencyCode(){
        String code = "";
        while (code.length() != 3){
            writeMessage("Введите код валюты");
            code = readString();
            if (code.length() != 3) writeMessage("Код валюты некорректен, попробуйте снова.");
        }
        return code.toUpperCase();
    }

    public String[] getValidTwoDigits(String currencyCode){
        return null;
    }

}
