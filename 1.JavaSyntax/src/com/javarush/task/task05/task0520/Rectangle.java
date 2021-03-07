package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    //напишите тут ваш код
	private int left, top, width, height;

	public int getLeft() {
		return left;
	}

	public int getTop() {
		return top;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Rectangle(int left, int top, int width, int height){
		this.left = left;
		this.top = top;
		this.width = width;
		this.height = height;
	}

	public Rectangle(int left, int top, int width){
		this.left = left;
		this.top = top;
		this.width = width;
		this.height = width;
	}

	public Rectangle(int left, int top){
		this.left = left;
		this.top = top;
		this.width = 0;
		this.height = 0;
	}

	public Rectangle(Rectangle otherRect){
		this.left = otherRect.getLeft();
		this.top = otherRect.getTop();
		this.width = otherRect.getWidth();
		this.height = otherRect.getHeight();
	}

	public static void main(String[] args) {

    }
}
