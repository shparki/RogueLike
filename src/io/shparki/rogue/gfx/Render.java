package io.shparki.rogue.gfx;

import io.shparki.rogue.util.Point2D;

import java.awt.Graphics2D;

public class Render {
	
	public static void drawRect(double x, double y, double width, double height, Graphics2D g2d){
		int newX = (int)( x - Window.offset.getX() );
		int newY = (int)( y - Window.offset.getY() );
		g2d.drawRect(newX, newY, (int)width, (int)height);
	}
	public static void drawRectRelativeTo(Point2D p, double x, double y, double width, double height, Graphics2D g2d){
		drawRect(x + p.getX(), y + p.getY(), width, height, g2d);
	}
	
	public static void fillRect(double x, double y, double width, double height, Graphics2D g2d){
		int newX = (int)( x - Window.offset.getX() );
		int newY = (int)( y - Window.offset.getY() );
		g2d.fillRect(newX, newY, (int)width, (int)height);
	}
	public static void fillRectRelativeTo(Point2D p, double x, double y, double width, double height, Graphics2D g2d){
		fillRect(x + p.getX(), y + p.getY(), width, height, g2d);
	}
	
	
	public static void drawString(String string, double x, double y, Graphics2D g2d){
		int newX = (int)( x - Window.offset.getX() );
		int newY = (int)( y - Window.offset.getY() );
		g2d.drawString(string, newX, newY);
	}
	public static void drawStringRelativeTo(Point2D p, String string, double x, double y, Graphics2D g2d){
		drawString(string, x + p.getX(), y + p.getY(), g2d);
	}
	
	public static void drawLine(double x1, double y1, double x2, double y2, Graphics2D g2d){
		int newX1 = (int) ( x1 - Window.offset.getX() );
		int newX2 = (int) ( x2 - Window.offset.getX() );
		
		int newY1 = (int) ( y1 - Window.offset.getY() );
		int newY2 = (int) ( y2 - Window.offset.getY() );
		g2d.drawLine(newX1, newY1, newX2, newY2);
	}
	public static void drawLineRelativeTo(Point2D p, double x1, double y1, double x2, double y2, Graphics2D g2d){
		drawLine(x1 + p.getX(), y1 + p.getY(), x2 + p.getX(), y2 + p.getY(), g2d);
	}
	
	
}
