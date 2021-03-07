package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory{
	public static ImageReader getImageReader(ImageTypes iType) throws IllegalArgumentException{
		try{
			ImageReader reader;
			switch (iType){
				case BMP: reader = new BmpReader();
					break;
				case JPG: reader = new JpgReader();
					break;
				case PNG: reader = new PngReader();
					break;
				default: throw new IllegalArgumentException("Неизвестный тип картинки");
			}
			return reader;
		} catch (NullPointerException ex){
			throw new IllegalArgumentException("Неизвестный тип картинки");
		}

	}
}
