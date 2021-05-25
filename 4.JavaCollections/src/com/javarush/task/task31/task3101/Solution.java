package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		Solution solution = new Solution();
		File path = new File(args[0]);
//		File path = new File("D:/test");
		File resultFileAbsolutePath = new File(args[1]);
//		File resultFileAbsolutePath = new File("D:/test/data1.txt");

		File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
		//if (!FileUtils.isExist(allFilesContent)) FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
		FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);

		HashMap<String, String> mapFiles = solution.getMapFiles(path);

		//System.out.println(mapFiles);

		Collection setFile = mapFiles.values();
		TreeSet<String> sortedSetFile = new TreeSet<>();
		sortedSetFile.addAll(setFile);

		FileOutputStream fos = new FileOutputStream( allFilesContent);
		BufferedOutputStream bufferedWriter = new BufferedOutputStream(fos);

		for (String nameFile: sortedSetFile) {
			for (Map.Entry entry: mapFiles.entrySet()) {
				if (nameFile.equals(entry.getValue())) {
					Path curFile = Paths.get(entry.getKey().toString());
					bufferedWriter.write(Files.readAllBytes(curFile));
					bufferedWriter.write("\n".getBytes());
				}
			}
			bufferedWriter.flush();
		}
		bufferedWriter.close();


		System.out.print(mapFiles);


	}

	public HashMap<String, String> getMapFiles(File path) throws IOException {
		File[] files = path.listFiles();
		HashMap<String, String> mapFiles = new HashMap<>();
		for (File file : files) {
			if (file.isFile() && Files.size(Paths.get(file.getAbsolutePath())) <= 50){
				mapFiles.put(file.getAbsolutePath(), file.getName());
			} else if (file.isDirectory()){
				HashMap<String,String> mapFilesInsidePath = getMapFiles(file);
				mapFiles.putAll(mapFilesInsidePath);
			}
		}
		return mapFiles;
	}

}
