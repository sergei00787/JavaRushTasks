package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
	public static List<String> getFileTree(String root) throws IOException {
		List<String> result = new ArrayList<>();
		File fl = new File(root);
		Path path = Paths.get(fl.getPath());
		LinkedList<File> queue = new LinkedList<>();
		queue.push(fl);
		while (!queue.isEmpty()) {
			File[] files = queue.pop().listFiles();
			for (File file : files) {
				if (Files.isDirectory(file.toPath())) {
					//System.out.println("Push \"" + file +"\"");
					queue.push(file);

				} else {
					result.add(file.getAbsolutePath());
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		try {
			List<String> list = getFileTree("D:/test");
			System.out.println(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
