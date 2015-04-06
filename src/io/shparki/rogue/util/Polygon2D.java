package io.shparki.rogue.util;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Polygon2D {
	
	private ArrayList<Point2D> vertices = new ArrayList<Point2D>();
	private int[] xPoints, yPoints;
	
	
	public Polygon2D(Point2D ... points){
		
		xPoints = new int[points.length];
		yPoints = new int[points.length];
		for (int i = 0; i < points.length; i++){
			xPoints[i] = (int)points[i].getX();
			yPoints[i] = (int) points[i].getY();
			
			vertices.add(points[i].getClone());
		}
	}
	
	public void render(Graphics2D g2d){
		g2d.drawPolygon(xPoints, yPoints, vertices.size());
	}
}
