package io.shparki.rogue;

import io.shparki.rogue.gfx.Window;
import io.shparki.rogue.io.Input;
import io.shparki.rogue.util.Rectangle;
import io.shparki.rogue.util.Time;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Engine extends Canvas implements Runnable{
	public static final int WIDTH = 1200;
	public static final int HEIGHT = WIDTH / 16 * 9;
	public static final String TITLE = "RogueLike";
	
	public static final int TARGET_UPS = 60;
	public static final long PERIOD = Time.SECOND / TARGET_UPS;
	public static int currentUPS = 0, currentFPS = 0;
	public static int UPS = 0, FPS = 0;
	
	private volatile boolean running = false;
	private volatile Thread animator;
	
	private BufferStrategy bs;
	private Graphics2D g2d;
	
	private Game game;
	
	
	
	public Engine(){
		Window.create(WIDTH, HEIGHT, TITLE + " | UPS: 000 FPS: 000", this);
		start();
	}
	
	public synchronized void start(){
		if (!running || animator == null){
			animator = new Thread(this, "Animator");
			animator.start();
		}
	}
	public synchronized void stop(){
		running = false;
	}
	
	public void run(){
		long beforeTime = 0, currentTime = System.nanoTime();
		long beforeUpdateTime = 0, currentUpdateTime = System.nanoTime();
		long upsCounter = 0, secCounter = 0;
		
		init();
		
		running = true;
		while (running){
			beforeTime = currentTime;
			currentTime = Time.getTime();
			Time.setDelta(currentTime - beforeTime);
			
			upsCounter += Time.getDelta();
			if (upsCounter >= PERIOD){
				beforeUpdateTime = currentUpdateTime;
				currentUpdateTime = Time.getTime();
				Time.setUpdateLong(currentUpdateTime - beforeUpdateTime);
				
				upsCounter -= PERIOD;
				currentUPS ++;
				update();
			}
			
			render();
			currentFPS ++;
			
			secCounter += Time.getDelta();
			if (secCounter >= Time.SECOND){
				secCounter -= Time.SECOND;
				UPS = currentUPS; FPS = currentFPS;
				currentUPS = 0; currentFPS = 0;
				Window.setTitle(TITLE + " | UPS: " + UPS + " FPS: " + FPS);
			}
			
		}
	}
	
	public void init(){
		game = new Game();
	}
	public void update(){
		game.update();
		Input.update();
	}
	public void render(){
		if (bs == null){
			bs = getBufferStrategy();
			if (bs == null){
				createBufferStrategy(3);
				return;
			}
		}
		
		g2d = (Graphics2D) bs.getDrawGraphics();
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, Window.getWidth(), Window.getHeight());
		
		game.render(g2d);
		
		bs.show();
		g2d.dispose();
	}
	
	
}
