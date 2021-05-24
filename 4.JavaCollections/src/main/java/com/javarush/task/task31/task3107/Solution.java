package com.javarush.task.task31.task3107;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Null Object Pattern
*/

public class Solution {
	private FileData fileData;

	public static void main(String... args) {
		Solution sol = new Solution("D:/test/data2.txt");
	}

	public Solution(String pathToFile) {
		try {
			boolean hidden = Files.isHidden(Paths.get(pathToFile));
			boolean executable = Files.isExecutable(Paths.get(pathToFile));
			boolean directory = Files.isDirectory(Paths.get(pathToFile));
			boolean writable = Files.isWritable(Paths.get(pathToFile));

			this.fileData = new ConcreteFileData(hidden, executable, directory, writable);
		} catch (Exception e) {
			this.fileData = new NullFileData(e);
		}
	}

	public FileData getFileData() {
		return fileData;
	}
}
