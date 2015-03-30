package io.shparki.rogue.io;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Input implements KeyListener, MouseListener{

	private static ArrayList<Integer> keysDown = new ArrayList<Integer>();
	private static ArrayList<Integer> keysPressed = new ArrayList<Integer>();
	private static ArrayList<Integer> keysReleased = new ArrayList<Integer>();
	
	private static ArrayList<Integer> buttonsDown = new ArrayList<Integer>();
	private static ArrayList<Integer> buttonsPressed = new ArrayList<Integer>();
	private static ArrayList<Integer> buttonsReleased = new ArrayList<Integer>();
	
	public static boolean isKeyDown(int keyCode) { return keysDown.contains(Integer.valueOf(keyCode)); }
	public static boolean isKeyPressed(int keyCode) { return keysPressed.contains(Integer.valueOf(keyCode)); }
	public static boolean isKeyReleased(int keyCode) { return keysReleased.contains(Integer.valueOf(keyCode)); }
		
	public static void update(){
		keysPressed.clear();
		keysReleased.clear();
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
	public void mousePressed(MouseEvent e) {  }
	public void mouseReleased(MouseEvent e) {  }
	
	
	
	public void keyTyped(KeyEvent e) {  }
	public void mouseClicked(MouseEvent e) {  }
	public void mouseEntered(MouseEvent e) {  }
	public void mouseExited(MouseEvent e) {  }
	
	
}
