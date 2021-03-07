package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution {

    public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	String pathString = reader.readLine();
//    	String pathString = "D:/test";
		Path path = Paths.get(pathString);

    	if (Files.exists(path) && Files.isDirectory(path)){
//			System.out.println(pathString);
			SFV visitor = new SFV();
			Files.walkFileTree(path, visitor);

			System.out.println("Всего папок - " + visitor.getCountFolder());
			System.out.println("Всего файлов - " + visitor.getCountFiles());
			System.out.println("Общий размер - " + visitor.getFilesSize());

		} else {
    		System.out.println(pathString + " - не папка");
		}
    }

    public static class SFV extends SimpleFileVisitor<Path>  {
    	private int countFolder = 0;
		private int countFiles = 0;
		private long filesSize = 0;

		public int getCountFolder() {
			return countFolder-1;
		}

		public int getCountFiles() {
			return countFiles;
		}

		public long getFilesSize() {
			return filesSize;
		}

		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
			System.out.println("DIR-" + dir.toString());
			countFolder++;
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			countFiles++;
			filesSize += Files.size(file);
			return FileVisitResult.CONTINUE;
		}
	}

}
