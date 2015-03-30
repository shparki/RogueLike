package io.shparki.rogue.world;

import io.shparki.rogue.Engine;
import io.shparki.rogue.util.Rectangle;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Map {
	
	public static final int TILE_SIZE  = 32;
	public static final int HEIGHT = 25, WIDTH = 25;
	public static final int SOLID_CHANCE = 35;
	public int[][] mapValues;
	private Random rand = new Random();
	
	
	public Map(){
		mapValues = new int[HEIGHT][WIDTH];
		
		for (int y = 2; y < HEIGHT; y++){
			for (int x = 2; x < WIDTH; x++){
				if (rand.nextInt(100) <= SOLID_CHANCE) { mapValues[y][x] = 1; } else { mapValues[y][x] = 0; }
			}
		}
		
		for (int y = 0; y < HEIGHT; y++){
			for (int x = 0; x < WIDTH; x++){
				if (mapValues[y][x] == 1 )Engine.collidingEntities.add(new Rectangle(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE));
			}
		}
	}
	
	public void updtae(){
		
	}
	
	public void render(Graphics2D g2d){
		g2d.setColor(Color.CYAN);
		for (int y = 0; y < HEIGHT; y++){
			for (int x = 0; x < WIDTH; x++){
				if (mapValues[y][x] == 1){
					g2d.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
				}
			}
		}
	}
	
	
}
