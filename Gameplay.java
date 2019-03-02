package HealthyChoices;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener{
	private Timer timer;
	private int delay = 75;
	private Image image;
	private int mainwidth;
    private int mainheight;
    private int health;
    private ImageObserver imageobserver;
    private int mainx = 300;
    private int mainy = 300;
    private boolean right = false;
    private boolean left = false;
    private boolean up = false;
    private boolean down = false;
    private boolean gooddecision = false;
    private boolean fired = false;
    private int firex =  mainx;
    
	public Gameplay() {
		addKeyListener(this);					//Makes the key listener and timer when the game object is created
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		health(100);
		timer.start();
	}
	
	public void paint(Graphics graphics) {
		   Color color = new Color(0, 255, 0, 255);
		   background(graphics);
		   mainchar(graphics);
		   if(fired) {
				fireball(graphics);
			}
		   graphics.dispose();
	}
	
	public void mainchar(Graphics graphics) {
		   Color color = new Color(20, 40, 55, 0);
		   ImageIcon mainboy = new ImageIcon("src/main_character.png");
	       image = mainboy.getImage(); 
	       mainwidth = image.getWidth(null);
	       mainheight = image.getHeight(null);
	       graphics.drawImage(image, mainx, mainy, mainwidth, mainheight, color, imageobserver);
	}
	
	public void health(int x) {
		health = x;
		int chocobar = -20;
		int apple = 40;
		if (gooddecision) {
			health = health + chocobar;
		}
		else if (health <= 60) {
			health = health + apple;
		}
		else
			health = 100;
	}
	
	public void background(Graphics graphics) {
		   Color color = new Color(20, 40, 55, 255);
	       graphics.setColor(color);
	       graphics.fillRect(0, 0, 10000, 10000);
	       graphics.drawImage(image, mainx, mainy, mainwidth, mainheight, color, imageobserver);
	       graphics.dispose();
	}

	public void fireball(Graphics graphics) {
		   Color color = new Color(20, 40, 55, 0);
		   ImageIcon mainboy = new ImageIcon("src/fireball.png");
	       image = mainboy.getImage(); 
	       mainwidth = image.getWidth(null);
	       mainheight = image.getHeight(null);
	       graphics.drawImage(image, firex, mainy, mainwidth, mainheight, color, imageobserver);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(right){ //if right and possibly some button pressed simultaneously, move this direction.
			if(up) { //right and up, move northeast.
				move(10, -10);
			}
			else if(down) { //right and down, move southeast
				move(10, 10);
			}
			else if(left) { //right and left, stay in place.
				move(0, 0);
			}
			else { //else, right is the only key pressed, so move right only
				move(10, 0);
			}
		}
		else if(left) { //if left and possibly some button pressed simultaneously, move this direction.
			if(up) { //left and up, move northwest
				move(-10, -10);
			}
			else if(down) { //left and down, move southwest
				move(-10, 10);
			}
			else if(right) { //left and right, stay in place.
				move(0, 0);
			}
			else { //move left if that's the only key pressed
				move(-10, 0);
			}
		}
		else if(up) { //if up and possibly some button pressed simultaneously, move this direction.
			if(down) { //up and down, stay in place
				move(0, 0);
			}
			else if(right) { //up and right, move northeast
				move(10, -10);
			}
			else if(left) { //up and left, move northwest
				move(-10, -10);
			}
			else { 
				move(0, -10); //move up if up is the only key pressed
			}
		}
		else if(down) {
			if(up) { //down and up, stay in place.
				move(0, 0);
			}
			else if(right) { //down and right, move southeast
				move(10, 10);
			}
			else if(left) { //down and left, move southwest
				move(-10, 10);
			}
			else { //only down is pressed, so move down
				move(0, 10);
			}
		}
	}
	
	public void move(int xDir, int yDir) {
		mainx += xDir;
		mainy += yDir;
		repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D) {
			right = true;	
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {
			up = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			down = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			left = true;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_D) {
			right = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			up = false;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	public void mousePressed(KeyEvent e) {
		
	}
}