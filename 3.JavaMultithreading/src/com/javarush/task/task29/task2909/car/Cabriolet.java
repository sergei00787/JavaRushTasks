package com.javarush.task.task29.task2909.car;

public class Cabriolet extends Car {
    public Cabriolet(int numberOfPassengers) {
        super(CABRIOLET, numberOfPassengers);
    }

    public int getMaxSpeed() {
        final int MAX_TRUCK_SPEED = 80;
        final int MAX_SEDAN_SPEED = 120;
        final int MAX_CABRIOLET_SPEED = 90;

        return MAX_CABRIOLET_SPEED;
    }

}
