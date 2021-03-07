package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Zerg zerg1 = new Zerg();
        zerg1.name = "Kulbyaka";
        Zerg zerg2 = new Zerg();
        zerg2.name = "Kulbyaka2";
        Zerg zerg3 = new Zerg();
        zerg3.name = "Kulbyaka3";
        Zerg zerg4 = new Zerg();
        zerg4.name = "Kulbyaka4";
        Zerg zerg5 = new Zerg();
        zerg5.name = "Kulbyaka5";
        
        Protoss protoss1 = new Protoss();
        protoss1.name = "Pups1";
        Protoss protoss2 = new Protoss();
        protoss2.name = "Pups2";
        Protoss protoss3 = new Protoss();
        protoss3.name = "Pups3";

        Terran ter1 = new Terran();
        ter1.name = "Ter1";
        Terran ter2 = new Terran();
        ter2.name = "Ter2";
        Terran ter3 = new Terran();
        ter3.name = "Ter3";
        Terran ter4 = new Terran();
        ter4.name = "Ter4";
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
