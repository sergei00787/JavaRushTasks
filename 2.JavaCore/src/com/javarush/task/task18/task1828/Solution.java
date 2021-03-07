package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* 
Прайсы 2
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String file = bufferedReader.readLine();
		//String file = "D:/data1.txt";

		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);

		ArrayList<Product> listProduct = new ArrayList<>();
		while (reader.ready()) {
			Product product = parseProduct(reader.readLine());
			listProduct.add(product);
		}

		switch (args[0]) {
			case "-u":
				replaceProducts(listProduct, args[1], args[2], args[3], args[4]);
				break;
			case "-d":
				deleteProduct(listProduct, args[1]);
				break;
		}

		FileOutputStream fileOutputStream = new FileOutputStream(file);

		listProduct.forEach((pr) -> {
			try {
				fileOutputStream.write(pr.toString().getBytes());
				fileOutputStream.write("\n".getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		bufferedReader.close();
		fileReader.close();
		fileOutputStream.close();
		reader.close();
		//listProduct.forEach((pr) -> System.out.println(pr.toString()));

	}

	public static void replaceProducts(ArrayList<Product> list, String argsId, String argsProductName, String argsPrice, String argsQuantity) {
		int id = Integer.parseInt(argsId.trim());
		String productName = argsProductName.trim();
		double price = Double.parseDouble(argsPrice);
		int quantity = Integer.parseInt(argsQuantity);

		for (int i = 0; i < list.size(); i++) {
			Product curProduct = list.get(i);
			if (curProduct.id == id) {
				curProduct.setProductName(productName);
				curProduct.setPrice(price);
				curProduct.setQuantity(quantity);
			}
		}
	}

	public static void deleteProduct(ArrayList<Product> list, String argsId) {
		int id = Integer.parseInt(argsId);
		for (int i=0; i < list.size(); i++) {
			Product curProduct = list.get(i);
			if (curProduct.id == id) {
				list.remove(i);
			}
		}
	}

	public static Product parseProduct(String row) {
		int id = Integer.parseInt(row.substring(0, 8).trim());
		String productName = row.substring(8, 38).trim();
		double price = Double.parseDouble(row.substring(38, 46).trim());
		int quantity = Integer.parseInt(row.substring(46, 49).trim());
		return new Product(id, productName, price, quantity);
	}

	public static class Product {
		private int id;
		private String productName;
		private double price;
		private int quantity;

		public Product(int id, String productName, double price, int quantity) {
			this.id = id;
			this.productName = productName;
			this.price = price;
			this.quantity = quantity;
		}

		@Override
		public String toString() {
			return String.format(Locale.ROOT, "%-8d%-30.30s%-8.2f%-4d", id, productName, price, quantity);
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	}

}
