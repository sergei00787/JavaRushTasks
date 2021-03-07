package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here - добавь код тут
		TestThread testThread = new TestThread();
		testThread.start();
		Thread.sleep(3000);
		testThread.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread{
    	public void run(){
    		try{
    			int i = 0;
    			Thread current = Thread.currentThread();
    			while (!current.isInterrupted()){
    				Thread.sleep(100);
    				i++;
				}
			} catch (InterruptedException ex){

			}
		}
    }
}