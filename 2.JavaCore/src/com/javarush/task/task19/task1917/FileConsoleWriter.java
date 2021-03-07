package com.javarush.task.task19.task1917;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

/* 
Свой FileWriter
*/

public class FileConsoleWriter {
	private FileWriter fileWriter;

	public static void main(String[] args) {

	}

	public FileConsoleWriter(String fileName) throws IOException {
		fileWriter = new FileWriter(fileName);
	}

	public FileConsoleWriter(String fileName, boolean append) throws IOException {
		fileWriter = new FileWriter(fileName, append);
	}

	public FileConsoleWriter(File file) throws IOException {
		fileWriter = new FileWriter(file);
	}

	public FileConsoleWriter(File file, boolean append) throws IOException {
		fileWriter = new FileWriter(file, append);
	}

	public FileConsoleWriter(FileDescriptor fd) {
		fileWriter = new FileWriter(fd);
	}

	public void write(char[] cbuf, int off, int len) throws IOException {
		fileWriter.write(cbuf, off, len);

		for (int i = off; i < off + len; i++) {
			System.out.print(String.valueOf(cbuf[i]));
		}
	}

	public void write(int c) throws IOException {
		fileWriter.write(c);
		System.out.print(String.valueOf(c));
	}

	public void write(String str) throws IOException {
		fileWriter.write(str);
		System.out.print(str);
	}

	public void write(String str, int off, int len) throws IOException {
		fileWriter.write(str, off, len);
		System.out.print(str.substring(off, off + len));
	}

	public void write(char[] cbuf) throws IOException {
		for (char c : cbuf) {
			System.out.print(String.valueOf(c));
		}

		fileWriter.write(cbuf);
	}

	public void close() throws IOException {
		fileWriter.close();
	}

}
