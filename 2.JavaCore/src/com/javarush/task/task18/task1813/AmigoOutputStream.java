package com.javarush.task.task18.task1813;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    //public static String fileName = "C:/tmp/result.txt";
    public static String fileName = "D:/data1.txt";


    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    private FileOutputStream original;

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
    	super(fileName);
    	this.original = fileOutputStream;
	}

	public void close() throws IOException {
    	original.flush();
    	byte[] jrarr = "JavaRush © All rights reserved.".getBytes();
    	original.write(jrarr);
    	original.close();
	}

	@Override
	public void flush() throws IOException {
		original.flush();
	}

	@Override
	public void write(int b) throws IOException {
		original.write(b);
	}

	@Override
	public void write(byte[] b) throws IOException {
		original.write(b);
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		original.write(b, off, len);
	}
}
