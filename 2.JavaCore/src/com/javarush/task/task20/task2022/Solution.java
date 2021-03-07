package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
	private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
		this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\r\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {

    	out.defaultWriteObject();
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
    	String file = "D:/data1.txt";
		Solution solution = new Solution(file);
		solution.writeObject("KUKUKY");

		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));

		objectOutputStream.writeObject(solution);
		solution.close();

		ObjectInputStream streamIn = new ObjectInputStream(new FileInputStream(file));
		Solution sol2 = (Solution) streamIn.readObject();
		sol2.writeObject("Данные нового потока.");
		sol2.close();
		streamIn.close();

    }
}
