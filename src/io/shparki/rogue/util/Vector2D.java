package io.shparki.rogue.util;

public class Vector2D {
	
	public static final Vector2D DOWN = new Vector2D(0, 1);
	public static final Vector2D UP = new Vector2D(0, -1);
	public static final Vector2D RIGHT = new Vector2D(1, 0);
	public static final Vector2D LEFT = new Vector2D(-1, 0);
	
	
	private double x, y;
	
	public Vector2D(double x, double y){
		this.x = x;
		this.y = y;
	}
	public Vector2D() { this(0, 0); }
	
	public double getX() { return x; }
	public void setX(double x) { this.x = x; }
	public void incX(double i) { x += i; }
	
	public double getY() { return y; }
	public void setY(double y) { this.y = y; }
	public void incY(double i) { y += i; }
	
	public void multiply(double d){ 
		x *= d;
		y *= d;
	}
	public void divide(double d){
		x /= d;
		y /= d;
	}
	
	public void add(Vector2D v){
		x += v.getX();
		y += v.getY();
	}
	public void subtract(Vector2D v){
		x -= v.getX();
		y -= v.getY();
	}
	public void multiply(Vector2D v){
		x *= v.getX();
		y *= v.getY();
	}
	public void divide(Vector2D v){
		x /= v.getX();
		y /= v.getY();
	}
	public double getDotProduct(Vector2D v){
		return (x * v.getX()) + (y * v.getY());
	}
	
	public double getMagnitude() { return Math.sqrt(x * x + y * y); }
	public void normalize() {
		x /= getMagnitude();
		y /=getMagnitude();
	}
	public void sychronize(){ multiply(Time.getUpdateRatio()); }
	
	public Vector2D toUp(){
		Vector2D v = getClone();
		v.multiply(UP);
		return v;
	}
	public Vector2D toDown(){
		Vector2D v = getClone();
		v.multiply(DOWN);
		return v;
	}
	public Vector2D toRight(){
		Vector2D v = getClone();
		v.multiply(RIGHT);
		return v;
	}
	public Vector2D toLeft(){
		Vector2D v = getClone();
		v.multiply(LEFT);
		return v;
	}
	public Vector2D getClone() { return new Vector2D(x, y); }
	
	public static Vector2D getVector2D(Point2D p1, Point2D p2){
		return new Vector2D(p2.getX() - p1.getX(), p2.getY() - p1.getY());
	}
}
