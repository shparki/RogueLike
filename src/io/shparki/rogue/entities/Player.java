package io.shparki.rogue.entities;

import io.shparki.rogue.Engine;
import io.shparki.rogue.io.Input;
import io.shparki.rogue.util.Point2D;
import io.shparki.rogue.util.Rectangle;
import io.shparki.rogue.util.Vector2D;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Player {
	
	public static final int SIZE = 16;
	public static final Vector2D VELOCITY = new Vector2D(100, 100);
	
	public Point2D location;
	public Point2D startLocation;
	
	
	public Player(int x, int y){
		location = new Point2D (x, y);
	}
	public Player() { this(0, 0); }
	
	public void update(){
		updateMovement();
	}
	
	
	public void updateMovement(){
		Vector2D vel = VELOCITY.getClone();
		vel.sychronize();
		
		if (Input.isKeyDown(KeyEvent.VK_W)) {
			location.add(vel.toUp());
			boolean collides = false;
			double newY = 0;
			
			for (Rectangle r : Engine.collidingEntities){
				if (location.getY() < r.getY() + r.getHeight() && location.getY() + SIZE > r.getY() + r.getHeight()){
					if (location.getX() < r.getX() + r.getWidth() && location.getX() + SIZE > r.getX()){
						collides = true;
						newY = r.getY() + r.getHeight();
						break;
					}
				}
			}
			if (collides) location.setY(newY);
		}
		if (Input.isKeyDown(KeyEvent.VK_S)) {
			location.add(vel.toDown());
			boolean collides = false;
			double newY = 0;
			
			for (Rectangle r : Engine.collidingEntities){
				if (location.getY() + SIZE > r.getY() && location.getY() < r.getY()){
					if (location.getX() < r.getX() + r.getWidth() && location.getX() + SIZE > r.getX()){
						collides = true;
						newY = r.getY();
						break;
					}
				}
			}
			if (collides) location.setY(newY - SIZE);
		}
		
		if (Input.isKeyDown(KeyEvent.VK_A)) {
			location.add(vel.toLeft());
			boolean collides = false;
			double newX = 0;
			
			for (Rectangle r: Engine.collidingEntities){
				if (location.getX() < r.getX() + r.getWidth() && location.getX() + SIZE > r.getX() + r.getWidth()){
					if (location.getY() < r.getY() + r.getHeight() && location.getY() + SIZE > r.getY()){
						collides = true;
						newX = r.getX() + r.getWidth();
						break;
					}
				}
			}
			
			if (collides) location.setX(newX);
		}
		if (Input.isKeyDown(KeyEvent.VK_D)) {
			location.add(vel.toRight());
			boolean collides = false;
			double newX = 0;
			
			for (Rectangle r: Engine.collidingEntities){
				if (location.getX() + SIZE > r.getX() && location.getX() < r.getX()){
					if (location.getY() < r.getY() + r.getHeight() && location.getY() + SIZE > r.getY()){
						collides = true;
						newX = r.getX();
						break;
					}
				}
			}
			
			if (collides) location.setX(newX - SIZE);
		}
	}
	
	
	public void render(Graphics2D g2d){
		g2d.setColor(Color.MAGENTA);
		g2d.fillRect((int)location.getX(), (int)location.getY(), SIZE, SIZE);
	}

	
	
}
