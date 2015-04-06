package io.shparki.rogue.world;

import io.shparki.rogue.entities.Player;
import io.shparki.rogue.gfx.Render;
import io.shparki.rogue.gfx.Window;
import io.shparki.rogue.util.Point2D;
import io.shparki.rogue.util.Rectangle;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

public class Map {
	
	public static final int TILE_SIZE  = 32;
	public static final int HEIGHT = 25, WIDTH = 25;
	public static final int SOLID_CHANCE = 50;
	public int[][] mapValues;
	private Random rand = new Random();
	private ArrayList<Rectangle> collidingEntities = new ArrayList<Rectangle>();
	private ArrayList<ArrayList<Point2D>> vertices = new ArrayList<ArrayList<Point2D>>();
	
	public Map(){
		mapValues = new int[HEIGHT][WIDTH];
		
		for (int y = 2; y < HEIGHT; y++){
			for (int x = 2; x < WIDTH; x++){
				if (rand.nextInt(100) <= SOLID_CHANCE) { mapValues[y][x] = 1; } else { mapValues[y][x] = 0; }
			}
		}
		
		for (int y = 0; y < HEIGHT; y++){
			for (int x = 0; x < WIDTH; x++){
				if (mapValues[y][x] == 1) collidingEntities.add(new Rectangle(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE));
			}
		}
		
		consolidate();
	}
	
	public void update(){
		
	}
	public void render(Graphics2D g2d){
		for (int y = 0; y < HEIGHT; y++){
			for (int x = 0; x < WIDTH; x++){
				if (mapValues[y][x] != 0 ){
					int startX = (int)(Window.getWidth() / 2 - Player.SIZE / 2);
					int startY = (int)(Window.getHeight() / 2 - Player.SIZE / 2);
					
					
					g2d.setColor(Color.BLUE);
					Render.fillRectRelativeTo(new Point2D(startX, startY), x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE, g2d);
					
					
					g2d.setColor(Color.WHITE);
					Render.drawRectRelativeTo(new Point2D(startX, startY), x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE, g2d);
					Render.drawStringRelativeTo(new Point2D(startX, startY), "" + mapValues[y][x], x * TILE_SIZE + 4, y * TILE_SIZE + 12, g2d);
				}
			}
		}
	}
	
	public ArrayList<Rectangle> getCollidingEntities(){ return collidingEntities; }
	
	int index = 2;
	public void consolidate(){
		for (int y = 0; y < HEIGHT; y++){
			for (int x = 0; x < WIDTH; x++){
				if (mapValues[y][x] == 1){
					flood(x, y, 1, index);
					index ++;
				}
			}
		}
		
		while (index > 1){
			ArrayList<Point2D> subVertices = new ArrayList<Point2D>();
			for (int y = 0; y < HEIGHT; y++){
				for (int x = 0; x < WIDTH; x++){
					if (mapValues[y][x] == index){
						subVertices.add(new Point2D(x, y));
						subVertices.add(new Point2D(x + 1, y));
						subVertices.add(new Point2D(x, y + 1));
						subVertices.add(new Point2D(x + 1, y + 1));
					}
				}
			}
			index --;
		}
		
		
	}
	public void flood(int x, int y, int valueFrom, int valueTo){
		if (mapValues[y][x] == valueFrom){
			mapValues[y][x] = valueTo;
			
			if (x + 1 < WIDTH) { flood(x + 1, y, valueFrom, valueTo); }
			if (x - 1 >= 0) { flood(x - 1, y, valueFrom, valueTo); }
			
			if (y + 1 < HEIGHT) { flood (x, y + 1, valueFrom, valueTo); }
			if (y - 1 >= 0) { flood(x, y - 1, valueFrom, valueTo); }
			
		}
	}
	




}
