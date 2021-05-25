package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.Home;
import com.javarush.task.task34.task3410.model.Player;
import com.javarush.task.task34.task3410.model.Box;
import com.javarush.task.task34.task3410.model.Wall;

import javax.swing.*;
import java.awt.*;


public class Field extends JPanel {
    private View view;

    public Field(View view) {
        this.view = view;
    }

    EventListener eventListener;

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Player player = new Player(30, 30);
        player.draw(g);
        Box box = new Box(50, 50);
        box.draw(g);
        Home home1 = new Home(70, 70);
        home1.draw(g);
        Wall wall = new Wall(30 , 100);
        wall.draw(g);
    }
}
