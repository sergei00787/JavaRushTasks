package com.javarush.task.task09.task0927;

import java.util.*;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
		Map<String, Cat> map = new HashMap<>();
		Cat cat1 = new Cat("Vasya");
		Cat cat2 = new Cat("Fwdw");
		Cat cat3 = new Cat("sdfgdrg");
		Cat cat4 = new Cat("sdrt");
		Cat cat5 = new Cat("erydf");
		Cat cat6 = new Cat("dfgyr");
		Cat cat7 = new Cat("sdft");
		Cat cat8 = new Cat("sdrer");
		Cat cat9 = new Cat("sdtwer");
		Cat cat10 = new Cat("etrsdg");

		map.put("Vasya",cat1);
		map.put("Fwdw",cat2);
		map.put("sdfgdrg",cat3);
		map.put("sdrt",cat4);
		map.put("erydf",cat5);
		map.put("dfgyr",cat6);
		map.put("sdft",cat7);
		map.put("sdrer",cat8);
		map.put("sdtwer",cat9);
		map.put("etrsdg",cat10);
				
		return  map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
		Set<Cat> cats = new HashSet();
		cats.addAll(map.values());
		return cats;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
