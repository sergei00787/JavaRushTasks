package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
	public static List<Thread> threads = new ArrayList<>(5);

	static {
		Thread th1 = new Thread(new Thread1());
		Thread th2 = new Thread(new Thread2());
		Thread th3 = new Thread(new Thread3());
		//Thread th4 = new Thread(new Thread4());
		Thread th5 = new Thread(new Thread5());
		threads.add(th1);
		threads.add(th2);
		threads.add(th3);
		threads.add(new Thread4());
		threads.add(th5);
	}

	public static void main(String[] args) {
		/*
		Thread th1 = new Thread(new Thread1());
		Thread th2 = new Thread(new Thread2());
		Thread th3 = new Thread(new Thread3());
		Thread th4 = new Thread(new Thread4());
		Thread th5 = new Thread(new Thread5());
		th1.start();

		th2.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}

		th2.interrupt();

		th3.start();

		th4.start();

		th5.start();
		*/
	}

	public static class Thread1 implements Runnable {
		public void run() {
			while (true) {
				//System.out.println("---------------");
			}
		}
	}

	public static class Thread2 extends Thread {
		public void run() {
			Thread current = Thread.currentThread();
			try {
				Thread.sleep(200);
			} catch (InterruptedException iex) {
				System.out.println("InterruptedException");
			}

		}
	}

	public static class Thread3 implements Runnable {
		public void run() {
			while (true) {
				System.out.println("Ура");
				try {
					Thread.sleep(500);
				} catch (InterruptedException exception) {
					exception.printStackTrace();
				}
			}
		}
	}

	public static class Thread4 extends Thread implements Message {
		//public static boolean isWarning = false;
		public void run() {
			while(!isInterrupted()){}
		}

		@Override
		public void showWarning() {
			interrupt();
		}
	}

	public static class Thread5 implements Runnable {
		public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		public void run() {
			int result = 0;
			String str = "";
			while (true) {
				try {
					if ((str = reader.readLine()).equals("N")) {
						System.out.println(result);
						break;
					}
					result = result + Integer.parseInt(str);
				} catch (IOException e) {

				} catch (NumberFormatException ex) {

				}

			}
		}
	}
}