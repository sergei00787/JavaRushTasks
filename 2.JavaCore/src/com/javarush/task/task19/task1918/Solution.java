package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.jsoup.Jsoup;
import org.jsoup.Jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

/* 
Знакомство с тегами
*/

public class Solution {
	public static void main(String[] args) throws IOException {
    	String tag = args[0];
//		String tag = "span";

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String file = reader.readLine();
//		String file = "D:/data1.txt";
		reader.close();

		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		StringBuilder sb = new StringBuilder();
		while (bufferedReader.ready()) {
			sb.append(bufferedReader.readLine());
		}
		bufferedReader.close();

		Document doc = Jsoup.parse(sb.toString(),"", Parser.xmlParser());
		Elements elements = doc.select(tag);

		for (Element e : elements) {
			System.out.println(e.toString());
		}

	}
}
