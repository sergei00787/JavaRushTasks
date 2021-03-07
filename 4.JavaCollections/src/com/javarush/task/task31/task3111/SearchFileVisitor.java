package com.javarush.task.task31.task3111;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
	private String partOfName;
	private String partOfContent;
	private int minSize;
	private int maxSize;
	private List<Path> foundFiles = new ArrayList<>();

	public void setPartOfName(String partOfName) {
		this.partOfName = partOfName;
	}

	public void setPartOfContent(String partOfContent) {
		this.partOfContent = partOfContent;
	}

	public void setMinSize(int minSize) {
		this.minSize = minSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public List<Path> getFoundFiles() {
		return foundFiles;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		byte[] content = Files.readAllBytes(file); // размер файла: content.length

		int countFilter = 0;
		int resultFilter = 0;

		if (!Objects.isNull(partOfName)) {
			countFilter++;
			String nameFile = file.getFileName().toString();
			if (nameFile.contains(partOfName)) {
				resultFilter++;
			}
		}

		if (!Objects.isNull(partOfContent)) {
			countFilter++;

			List<String> strings = Files.readAllLines(file);
			for (String str : strings) {
				if (str.contains(partOfContent)) {
					resultFilter++;
					break;
				}
			}
		}

		if (minSize != 0) {
			countFilter++;
			if (Files.size(file) >= minSize) resultFilter++;
		}

		if (maxSize !=0) {
			countFilter++;
			if (Files.size(file) <= maxSize) resultFilter++;
		}

		if (countFilter == resultFilter) foundFiles.add(file);

		return super.visitFile(file, attrs);
	}
}
