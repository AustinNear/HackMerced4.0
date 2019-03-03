package HealthyChoices;
import java.awt.Color;
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
    private int backwidth;
    private int backheight;
    private ImageObserver imageobserver;
    private int mainx = 100;
    private int mainy = 500;
    private boolean right = false;
    private boolean left = false;
    private boolean up = false;
    private boolean down = false;
    private boolean fired = false;
    private int initFireX = mainx;
    private int firex =  mainx;
    private int firey = mainy;
    private int distanceFired = 0;
    ImageIcon background = new ImageIcon("src/level1animatedoptimized.gif");
    ImageIcon mainboy = new ImageIcon("src/eggdefaultstancesmall.png");
    ImageIcon fireball = new ImageIcon("src/fireball.png");
	public Gameplay() {
		addKeyListener(this);					//Makes the key listener and timer when the game object is created
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
	
	
	public void paint(Graphics graphics) {
		background(graphics);   
		mainchar(graphics);
		if(fired) {
			fireball(graphics);
		}
		graphics.dispose();
		repaint();
	}
	
	
	public void mainchar(Graphics graphics) {
		   Color color = new Color(20, 40, 55, 0);
	       image = mainboy.getImage(); 
	       mainwidth = image.getWidth(null);
	       mainheight = image.getHeight(null);
	       graphics.drawImage(image, mainx, mainy, mainwidth, mainheight, color, imageobserver);
	}
	
	public void background(Graphics graphics) {
		   Color color = new Color(20, 40, 55, 0);
	       image = background.getImage(); 
	       backwidth = image.getWidth(null);
	       backheight = image.getHeight(null);
	       graphics.drawImage(image, 0, 0, 905, 700, color, imageobserver);
	}
	
	public void fireball(Graphics graphics) {
		   Color color = new Color(20, 40, 55, 0);
		   ImageIcon fireball = new ImageIcon("src/fireball.png");
	       image = fireball.getImage(); 
	       mainwidth = image.getWidth(null);
	       mainheight = image.getHeight(null);
	       graphics.drawImage(image, firex, firey, mainwidth, mainheight, color, imageobserver);
	       
	}
	
	public void move(int xDir, int yDir) {
		mainboy = new ImageIcon("src/warker.gif");
		mainx += xDir;
		mainy += yDir;
		
	}
	@Override
	
	public void actionPerformed(ActionEvent e) {
		if(fired) {
			firex += 30;
			distanceFired += 30;
			if(distanceFired > (initFireX + 150)) {
				fired = false;
				firex = mainx;
				firey = mainy;
				distanceFired = 0;
			}
		}
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
		
		if(e.getKeyCode() == KeyEvent.VK_F) {
			fired = true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_D) {
			right = false;
			mainboy = new ImageIcon("src/eggdefaultstancesmall.png");
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			down = false;
			mainboy = new ImageIcon("src/eggdefaultstancesmall.png");
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			left = false;
			mainboy = new ImageIcon("src/eggdefaultstancesmall.png");
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			up = false;
			mainboy = new ImageIcon("src/eggdefaultstancesmall.png");
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
