package io.shparki.rogue;

import io.shparki.rogue.entities.Player;
import io.shparki.rogue.util.Rectangle;
import io.shparki.rogue.world.Map;

import java.awt.Color;
import java.awt.Graphics2D;

public class Game {
	
	private Player player;
	private Map map;
	
	
	
	public Game(){
		player = new Player(0, 0);
		map = new Map();
	}
	
	public void update(){
		player.update();
	}
	public void render(Graphics2D g2d){
		map.render(g2d);
		player.render(g2d);
	}
	
}
