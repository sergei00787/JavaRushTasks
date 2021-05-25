package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Box extends CollisionObject implements Movable{
    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        graphics.fillRect(x, y, width, height);
    }

    @Override
    public void move(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }
}
