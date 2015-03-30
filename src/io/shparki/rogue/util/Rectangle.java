package io.shparki.rogue.util;

public class Rectangle {
	
	private int x, y;
	private int width, height;
	
	public Rectangle(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	
	public int getX() { return x; }
	public void setX(int x) { this.x = x; }
	public void incX (int i) { x += i; }
	
	public int getY() { return y; }
	public void setY(int y) { this.y = y; }
	public void incY(int i) { y += i; }
	
	public int getWidth() { return width; }
	public int getHeight() { return height; }
}
