package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        //напишите тут ваш код
        for (int i=0; i< strings.size(); ){
            String curStr = strings.get(i);
             
            if (curStr.indexOf("р") >= 0 && curStr.indexOf("л") >= 0) i++;
            else if (curStr.indexOf("р") >= 0) {
                strings.remove(i);
            }
            else if (curStr.indexOf("л") >= 0) {
                strings.add(i,strings.get(i));
                i+=2;
            } else i++;
        }
        return strings;
    }
}