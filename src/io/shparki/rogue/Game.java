package io.shparki.rogue;

import io.shparki.rogue.entities.Player;
import io.shparki.rogue.gfx.Render;
import io.shparki.rogue.gfx.Window;
import io.shparki.rogue.io.Input;
import io.shparki.rogue.util.Point2D;
import io.shparki.rogue.util.Vector2D;
import io.shparki.rogue.world.Map;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Game {
	public static Player player;
	public static Map map;
	
	
	
	
	public Game(){
		player = new Player(0, 0);
		map = new Map();
	}
	
	public void update(){
		player.update();
		
		if (Input.isKeyPressed(KeyEvent.VK_ENTER)) {
			player = new Player(0, 0);
			map = new Map();
		}
		
		updateVision();
	}
	public void render(Graphics2D g2d){
		map.render(g2d);
		player.render(g2d);
		
		g2d.setColor(Color.MAGENTA);
		Render.drawLineRelativeTo(player.location, Window.getWidth() / 2, Window.getHeight() / 2, Input.mouse.getX(), Input.mouse.getY(), g2d);
	}
	
	
	
	public void updateVision(){
		
	}
	
}
