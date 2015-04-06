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
	
	public Point2D[] getVertices(){
		Point2D[] points = new Point2D[4];
		
		points[0] = new Point2D(x, y);
		points[1] = new Point2D(x + width, y);
		points[2] = new Point2D(x, y + height);
		points[3] = new Point2D(x + width, y + height);
		
		return points;
	}
	
}
