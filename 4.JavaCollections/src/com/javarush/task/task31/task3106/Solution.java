package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		String fileResult = args[0];

		TreeSet<String> setFiles = new TreeSet<>();

		for (int i = 1; i < args.length; i++) {
			setFiles.add(args[i]);
		}

		ArrayList<InputStream> listInpStr = new ArrayList<>();
		for (String file : setFiles) {
			listInpStr.add(new FileInputStream(file));
		}

		FileOutputStream fos = new FileOutputStream(fileResult);

		SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(listInpStr));
		try( ZipInputStream zis = new ZipInputStream(sequenceInputStream)) {
			ZipEntry entry = zis.getNextEntry();

			byte[] buff = new byte[2048];
			int count;

			while ((count = zis.read(buff)) > 0) {
				fos.write(buff, 0, count);
				fos.flush();
			}

			zis.closeEntry();
		}
		fos.close();
	}
}
