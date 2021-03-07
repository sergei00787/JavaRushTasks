package com.javarush.task.task20.task2017;

import java.io.*;

/* 
Десериализация
*/

public class Solution {
	public A getOriginalObject(ObjectInputStream objectStream) {
		A result ;
		try {
			result = (A) objectStream.readObject();
		} catch (Exception e) {
			result = null;
		}
		return result;
	}

	public class A implements Serializable {
		public A() {
			System.out.println("inside A");
		}
	}

	public class B extends A {
		public B() {
			System.out.println("inside B");
		}
	}

	public static void main(String[] args) throws IOException {
		/*
		File file = File.createTempFile("temp", null);
		FileOutputStream outputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

		Solution solution = new Solution();
		A a = new A();
		objectOutputStream.writeObject(a);


		FileInputStream fileInputStream = new FileInputStream(file);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

		A obj1 = solution.getOriginalObject(objectInputStream);
		System.out.println(obj1);

		B b = new B();
		objectOutputStream.writeObject(b);
		A obj2 = solution.getOriginalObject(objectInputStream);
		System.out.println(obj2);

		objectOutputStream.close();
		objectInputStream.close();
		*/

	}
}
