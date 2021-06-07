package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/

public class Solution extends Thread {
    public Solution() {
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                if (e instanceof Error) {
                    System.out.println("Нельзя дальше работать");
                } else if (e instanceof Exception) {
                    System.out.println("Надо обработать");
                } else if (e instanceof Throwable){
                    System.out.println("Поживем - увидим");
                }
            }
        });
    }

    public void throwError(){
        throw new Error("Error");
    }

    public void throwException(){
        try {
            throw new Exception("Exception");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void throwThrowable(){
        try {
            throw new Throwable("Throwable");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void run() {
        throwThrowable();
        throwException();
        throwError();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();
    }
}
