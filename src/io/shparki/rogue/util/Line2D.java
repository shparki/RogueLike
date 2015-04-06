package io.shparki.rogue.util;

import java.awt.Graphics2D;

public class Line2D {
	
	private Point2D start, end;
	
	public Line2D(Point2D start, Point2D end){
		this.start = start.getClone();
		this.end = end.getClone();
	}
	public Line2D(double sx, double sy, double ex, double ey){ this(new Point2D(sx, sy), new Point2D(ex, ey)); }
	
	
	public Point2D getStart() { return start; }
	public Point2D getEnd() { return end; }
	
	public void render(Graphics2D g2d){
		g2d.drawLine((int)start.getX(), (int)start.getY(), (int)end.getX(), (int)end.getY());
	}
	
	
}
