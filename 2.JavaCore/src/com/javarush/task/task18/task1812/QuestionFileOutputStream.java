package com.javarush.task.task18.task1812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
	private AmigoOutputStream original;

	public QuestionFileOutputStream(AmigoOutputStream amigoOutputStream) {
		super();
		this.original = amigoOutputStream;
	}

	@Override
	public void close() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Вы действительно хотите закрыть поток? Д/Н");
		String response = reader.readLine();
		if (response.equals("Д")) {
			reader.close();
			original.close();
		}
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

