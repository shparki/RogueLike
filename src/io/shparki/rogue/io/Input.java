package io.shparki.rogue.io;

import io.shparki.rogue.gfx.Window;
import io.shparki.rogue.util.Point2D;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Input implements KeyListener, MouseListener, MouseMotionListener{

	private static ArrayList<Integer> keysDown = new ArrayList<Integer>();
	private static ArrayList<Integer> keysPressed = new ArrayList<Integer>();
	private static ArrayList<Integer> keysReleased = new ArrayList<Integer>();
	
	private static ArrayList<Integer> buttonsDown = new ArrayList<Integer>();
	private static ArrayList<Integer> buttonsPressed = new ArrayList<Integer>();
	private static ArrayList<Integer> buttonsReleased = new ArrayList<Integer>();
	
	public static boolean isKeyDown(int keyCode) { return keysDown.contains(Integer.valueOf(keyCode)); }
	public static boolean isKeyPressed(int keyCode) { return keysPressed.contains(Integer.valueOf(keyCode)); }
	public static boolean isKeyReleased(int keyCode) { return keysReleased.contains(Integer.valueOf(keyCode)); }
		
	public static boolean isButtonDown(int button) { return buttonsDown.contains(Integer.valueOf(button)); }
	public static boolean isButtonPressed(int button) { return buttonsPressed.contains(Integer.valueOf(button)); }
	public static boolean isButtonReleased(int button) { return buttonsReleased.contains(Integer.valueOf(button)); }
	
	public static Point2D mouseClick = new Point2D(), mouseClickInGame = new Point2D();
	public static Point2D mouse = new Point2D(), mouseInGame = new Point2D();
	
	
	public static void update(){
		keysPressed.clear();
		keysReleased.clear();
		
		buttonsPressed.clear();
		buttonsReleased.clear();
		
		mouseClick = null;
		mouseClickInGame = null;
		
		mouseInGame = new Point2D(mouse.getX() + Window.offset.getX() - Window.getWidth() / 2, mouse.getY() + Window.offset.getY() - Window.getHeight() / 2);
	}
	
	
	
	public void keyPressed(KeyEvent e) {
		if (!isKeyDown(e.getKeyCode())){
			if (!isKeyPressed(e.getKeyCode())){
				keysPressed.add(Integer.valueOf(e.getKeyCode()));
			}
			keysDown.add(Integer.valueOf(e.getKeyCode()));
		}
	}
	public void keyReleased(KeyEvent e) { 
		if (isKeyDown(e.getKeyCode())){
			if (!isKeyReleased(e.getKeyCode())){
				keysReleased.add(Integer.valueOf(e.getKeyCode()));
			}
			keysDown.remove(Integer.valueOf(e.getKeyCode()));
		}
	}
	public void mousePressed(MouseEvent e) { 
		if (!isButtonDown(e.getButton())){
			if (!isButtonPressed(e.getButton())){
				buttonsPressed.add(Integer.valueOf(e.getButton()));
				mouseClick = new Point2D(e.getX(), e.getY());
			}
			buttonsDown.add(Integer.valueOf(e.getButton()));
		}
	}
	public void mouseReleased(MouseEvent e) { 
		if (isButtonDown(e.getButton())){
			if (!isButtonReleased(e.getButton())){
				buttonsReleased.add(Integer.valueOf(e.getButton()));
			}
			buttonsDown.remove(Integer.valueOf(e.getButton()));
		}
	}
	public void mouseMoved(MouseEvent e) { 
		mouse = new Point2D(e.getX(), e.getY());
		mouseInGame = new Point2D(e.getX() + Window.offset.getX() - Window.getWidth() / 2, e.getY() + Window.offset.getY() - Window.getHeight() / 2);
	}
	
	
	
	public void keyTyped(KeyEvent e) {  }
	public void mouseClicked(MouseEvent e) {  }
	public void mouseEntered(MouseEvent e) {  }
	public void mouseExited(MouseEvent e) {  }
	public void mouseDragged(MouseEvent e) { }
	
	
}
