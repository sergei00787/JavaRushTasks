package com.javarush.task.task37.task3711;

public class Computer {
    public Computer(){

    }

    private CPU cpu = new CPU();
    private Memory memory = new Memory();
    private HardDrive hardDrive = new HardDrive();

    public void run(){
        hardDrive.storeData();
        memory.allocate();
        cpu.calculate();
    }
}
