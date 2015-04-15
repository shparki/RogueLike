package io.shparki.rogue.util;

import io.shparki.rogue.gfx.Render;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Polygon {
	
	private ArrayList<Point2D> vertices = new ArrayList<Point2D>();
	
	public Polygon(ArrayList<Point2D> vertices){
		this.vertices = vertices;
	}
	
	
	public void render(Graphics2D g2d){
		Render.drawPolygon(vertices, g2d);
	}
}
