package com.javarush.task.task19.task1916;

import sun.misc.Queue;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
	public static List<LineItem> lines = new ArrayList<LineItem>();

	public static void main(String[] args) throws IOException {
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
    	String file1 = consoleReader.readLine();
    	String file2 = consoleReader.readLine();
//		String file1 = "D:/data1.txt";
//		String file2 = "D:/data2.txt";

		consoleReader.close();

		BufferedReader reader1 = new BufferedReader(new FileReader(file1));
		BufferedReader reader2 = new BufferedReader(new FileReader(file2));
		LinkedList<String> queue1 = new LinkedList<>();
		LinkedList<String> queue2 = new LinkedList<>();

		while (reader1.ready()) {
			queue1.add(reader1.readLine());
		}

		while (reader2.ready()) {
			queue2.add(reader2.readLine());
		}

		String head1 = "";
		String head2 = "";
		String next1 = "";
		String next2 = "";
		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			head1 = queue1.pop();
			head2 = queue2.pop();
			if (head1.equals(head2)) {
				lines.add(new LineItem(Type.SAME, head1));
			} else {
				next1 = queue1.peek();
				if (next1.equals(head2)) {
					lines.add(new LineItem(Type.REMOVED, head1));
					queue2.push(head2);
				} else {
					lines.add(new LineItem(Type.ADDED, head2));
					queue1.push(head1);
				}
			}
		}
		if (!queue1.isEmpty()) {
			while (!queue1.isEmpty()) {
				lines.add(new LineItem(Type.REMOVED, queue1.pop()));
			}
		}
		if (!queue2.isEmpty()) {
			while (!queue2.isEmpty()) {
				lines.add(new LineItem(Type.ADDED, queue2.pop()));
			}
		}

		reader1.close();
		reader2.close();

		/*
		for (LineItem li : lines) {
			System.out.println(li.line + " - " + li.type);
		}*/
	}


	public static enum Type {
		ADDED,        //добавлена новая строка
		REMOVED,      //удалена строка
		SAME          //без изменений
	}

	public static class LineItem {
		public Type type;
		public String line;

		public LineItem(Type type, String line) {
			this.type = type;
			this.line = line;
		}
	}
}
