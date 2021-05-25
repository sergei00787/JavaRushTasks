package com.javarush.task.task37.task3707;

import java.util.ArrayList;

public class main {
    public static void main(String... args){
        AmigoSet<String> amigoSet = new AmigoSet<>();

        ArrayList<String> list = new ArrayList<>();
        list.add("sdf");
        list.add("sdfg");
        list.add("dfgdfh");
        list.add("dfhdjhdfgj");

        amigoSet.add("sdfgdf");
        amigoSet.add("asdfgsdlfgk");
        //amigoSet.addAll(list);
        System.out.println(amigoSet.toString());
    }
}
