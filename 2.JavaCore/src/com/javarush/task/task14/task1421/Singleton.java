package com.javarush.task.task14.task1421;

import java.util.Objects;

public class Singleton {
	private static Singleton instance = null;

	public static Singleton getInstance() {
		if (Objects.isNull(instance)) instance = new Singleton();
		return instance;
	}

	private Singleton() {
	}

}
