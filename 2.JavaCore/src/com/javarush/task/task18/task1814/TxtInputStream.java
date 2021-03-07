package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

	private FileInputStream original;

    public TxtInputStream(String fileName) throws UnsupportedFileNameException, IOException {
		super(fileName);

		if (!fileName.endsWith(".txt")) {
			super.close();
			throw new UnsupportedFileNameException();
		} else {
			original = new FileInputStream(fileName);
		}
    }



    public static void main(String[] args) {
    }
}

