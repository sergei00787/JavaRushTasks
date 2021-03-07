package com.javarush.task.task20.task2014;

import com.sun.corba.se.pept.encoding.InputObject;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Externalizable {
	public static void main(String[] args) {
		File file = new File("D:/data1.txt");
		try (
			 FileInputStream fileInputStream = new FileInputStream(file);
			 FileOutputStream fileOutputStream = new FileOutputStream(file);
		){
			ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
			Solution savedObject = new Solution(3);
			savedObject.writeExternal(outputStream);
			outputStream.close();

			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			Solution loadedObject = new Solution(4);
			loadedObject.readExternal(inputStream);
			inputStream.close();
			//System.out.println(new Solution(4));

			System.out.println(savedObject.string.equals(loadedObject.string));
		} catch (IOException ioEx){
			ioEx.printStackTrace();
		} catch (ClassNotFoundException cnfEx){
			cnfEx.printStackTrace();
		}
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(string);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		string = (String) in.readObject();
	}

	transient private final String pattern = "dd MMMM yyyy, EEEE";
	transient private Date currentDate;
	transient private int temperature;
	String string;

	public Solution(int temperature) {
		this.currentDate = new Date();
		this.temperature = temperature;

		string = "Today is %s, and the current temperature is %s C";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		this.string = String.format(string, format.format(currentDate), temperature);
	}

	@Override
	public String toString() {
		return this.string;
	}
}
