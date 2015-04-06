package io.shparki.rogue.entities;

import io.shparki.rogue.gfx.Window;
import io.shparki.rogue.util.Point2D;
import io.shparki.rogue.util.Vector2D;

import java.awt.Color;
import java.awt.Graphics2D;


public class Bullet {
	
	public static final double LENGTH = 5;
	public static final double SPEED = .1;
	
	private Point2D start, end;
	private Vector2D direction, velocity;
	
	
	
	
	public Bullet(Point2D start, Vector2D direction){
		this.direction = direction.getClone();
		this.direction.normalize();
		
		velocity = direction.getClone();
		velocity.multiply(SPEED);
		
		this.start = start.getClone();
		start.incX(Window.offset.getX());
		start.incY(Window.offset.getY());
		
		end = start.getClone();
		end.add(velocity);
		
		System.out.println(start);
		System.out.println(end);
	}
	
	public void update(){
		start = end.getClone();
		end.add(velocity);
	}
	
	public void render(Graphics2D g2d){
		g2d.setColor(Color.WHITE);
		g2d.drawLine((int)(start.getX() + Window.offset.getX()), (int)start.getY(), (int)end.getX(), (int)end.getY());
	}
	
}
