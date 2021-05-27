package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String... args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        Horse h1 = new Horse("Jetta", 3, 0);
        Horse h2 = new Horse("Lambo", 3, 0);
        Horse h3 = new Horse("Cherry", 3, 0);
        horses.add(h1);
        horses.add(h2);
        horses.add(h3);
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    };
    public void move(){
        for (Horse horse: horses) {
            horse.move();
        }
    };
    public void print(){
        for (Horse horse: horses) {
            horse.print();
            System.out.println();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    };

    public Horse getWinner(){
        Horse result = horses.get(0);
        for (Horse horse: horses) {
            if (horse.getDistance() > result.getDistance()) result = horse;
        }
        return result;
    }

    public void printWinner(){
        Horse winner  = getWinner();
        System.out.println("Winner is "+winner.getName() + "!");
    }


}
