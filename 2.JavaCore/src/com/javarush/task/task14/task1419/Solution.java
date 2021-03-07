package com.javarush.task.task14.task1419;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
		try {
			throw new ClassCastException();
		} catch(ClassCastException e){
			exceptions.add(e);
		}

		try {
			throw new IndexOutOfBoundsException();
		} catch (IndexOutOfBoundsException e){
			exceptions.add(e);
		}
		try {
			throw new RuntimeException();
		} catch (RuntimeException e){
			exceptions.add(e);
		}

		try {
			throw new IllegalArgumentException();
		} catch (IllegalArgumentException e){
			exceptions.add(e);
		}

		try {
			throw new IllegalAccessException();
		} catch (IllegalAccessException e){
			exceptions.add(e);
		}

		try {
			throw new NumberFormatException();
		} catch (NumberFormatException e){
			exceptions.add(e);
		}
		try {
			throw new SocketException();
		} catch (SocketException e){
			exceptions.add(e);
		}

		try {
			throw new IOException();
		} catch (IOException e){
			exceptions.add(e);
		}
		
		try {
			throw new FileNotFoundException();
		} catch (FileNotFoundException e){
			exceptions.add(e);
		}

    }
}
