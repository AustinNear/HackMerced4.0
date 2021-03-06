package HealthyChoices;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.util.Random;

import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.Timer;
public class Gameplay extends JPanel implements KeyListener, ActionListener{
	private Timer timer;
	private int delay = 75;
	private Image image;
    private int backwidth;
    private int backheight;
    private int fireheight;
    private int firewidth;
    private int foodwidth;
    private int foodheight;
    private int place;
    private ImageObserver imageobserver;
    private int mainx = 50;
    private int mainy = 500;
    private boolean right = false;
    private boolean left = false;
    private boolean up = false;
    private boolean down = false;
    private boolean fired = false;
    private int firex =  mainx; //the actual x coordinate of the fireball being shot.
    private int firey = mainy;
    private int distanceFired = 0;
    private int stage = 0;
    private boolean falling = false;
    private boolean deployed = false;
    private int fallycoords = 0;
    ImageIcon background = new ImageIcon("src/level1animatedoptimized.gif");
    ImageIcon mainboy = new ImageIcon("src/eggdefaultsmallsmallright.png");
    ImageIcon food = new ImageIcon("src/darkcolasmall.png");
    private Image mainim = mainboy.getImage();
    private int mainwidth = mainim.getWidth(null);
    private int mainheight = mainim.getHeight(null);
    private boolean end = true;
    private int foodspeed = 2;
    
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
		if(falling){
			fallgame(graphics);
		}
		stagetext(graphics);
		graphics.dispose();
		repaint();
	}
	
	public void stagetext(Graphics graphics) {
		graphics.setColor(Color.WHITE);
		graphics.setFont(new Font("arial", Font.BOLD, 15));
		if(stage == 0) {
			graphics.drawString("As you can see, this gyrodynetic hypersphere is real, an actual holotopic space/time with the very same attributes we have ", 10, 40);
			graphics.drawString("in the 3rd dimension, such as distance, time, gravity, inertia, acceleration and awareness.", 10, 60);
		}
		if(stage == 1) {
			graphics.drawString("We're just realizing the sympaktic method to actually activate zero point equivalence where the 4th, 5th, 6th, 7th, 8th and 9th dimensional perpendicular axis is to be found when fathoming, floating, flowing and frolicking between the coherent and convergent multitudes of orthogonal quantum latency. ", 10, 50);
			graphics.drawString("dimensional perpendicular axis is to be found when fathoming, floating, flowing and frolicking between the coherent and convergent multitudes of orthogonal quantum latency. ", 10, 70);
			graphics.drawString("convergent multitudes of orthogonal quantum latency. ", 10, 90);
		}
		if(stage == 2) {
			graphics.drawString(" This intractable enigma, created by encountering the vast expanses of orthogonal freedom to travel around in and discover ", 10, 40);
			graphics.drawString("throughout where to combine vorticular directions and symplectic entanglements that happen to occur when orchestrating ", 10, 60);
			graphics.drawString("a perpendicular plethora in this apparent and yet invisible locality, is beyond comprehension.", 10, 80);
		}
	}
	
	public void fallgame(Graphics graphics) {
		Random rnum = new Random();
		int[] fallxcoords = {100, 150, 200, 250, 300, 350, 400, 450, 500, 550, 600, 650, 700, 750, 800, 850, 900};
        if(deployed == false)
			place = rnum.nextInt(16);
        deployed = true;
        Color color = new Color(20, 40, 55, 0);
	    image = food.getImage(); 
	    foodwidth = image.getWidth(null);
	    foodheight = image.getHeight(null);
	    if(mainx + mainwidth  >= fallxcoords[place] && mainx <= fallxcoords[place] && mainy + mainheight >= fallycoords && mainy <= fallycoords) {
	       if(mainheight < 1000)
	    	   mainheight = mainheight+20;
	       if(mainwidth<1000)
	    	   mainwidth = mainwidth+20;
	       if(mainwidth >= 1000 && mainheight >= 1000) {
	    	   mainwidth = 905;
	    	   mainheight = 700;
	    	   mainx = 0;
	    	   mainy = 0;
	    	   end = false;
	    	   foodspeed = -1;
	    	   foodwidth = 0;
	    	   foodheight = 0;
	    	   mainboy = new ImageIcon("src/fullfacechangerfinal.gif");
	    	   mainim = mainboy.getImage();
	    	   
	       }
	    }
	    graphics.drawImage(image, fallxcoords[place], fallycoords, foodwidth, foodheight, color, imageobserver);
	    fallycoords += foodspeed;
	    if(fallycoords >= 700) {
	    	fallycoords = 0;
	    	deployed = false;
	    }
        
		
	}
	
	public void mainchar(Graphics graphics) {
		   Color color = new Color(20, 40, 55, 0); 
	       graphics.drawImage(mainim, mainx, mainy, mainwidth, mainheight, color, imageobserver);
	}
	
	public void background(Graphics graphics) {
		   Color color = new Color(20, 40, 55, 0);
		   if(mainx > 850 && stage == 0) {
			   background = new ImageIcon("src/level2.png"); //test image while next is being made
			   mainx = 50;
			   stage++;
		   }
		   if(mainx > 850 && stage == 1) {
			   background = new ImageIcon("src/level3.png"); //test image while next is being made
			   mainx = 50;
			   stage++;
			   falling = true;
		   }
	       image = background.getImage(); 
	       backwidth = image.getWidth(null);
	       backheight = image.getHeight(null);
	       graphics.drawImage(image, 0, 0, 905, 700, color, imageobserver);
	}

	public void fireball(Graphics graphics) {
		Color color = new Color(20, 40, 55, 0);
		ImageIcon fireball = new ImageIcon("src/fireball.png");
		image = fireball.getImage(); 
		firewidth = image.getWidth(null);
		fireheight = image.getHeight(null);
		graphics.drawImage(image, firex, firey, firewidth, fireheight, color, imageobserver);

	}

	public void move(int xDir, int yDir) {
		mainboy = new ImageIcon("src/warker.gif");
		mainim = mainboy.getImage();
		mainx += xDir;
		mainy += yDir;

	}
	@Override

	public void actionPerformed(ActionEvent e) {
		if(end) {
			if(fired) {
				int currX = mainx;
				int currY = mainy;
				if(distanceFired == 0) {
					firex = currX + 50;
					firey = currY;
				}
				firex += 50;
				firey += 0;
				distanceFired += 50;
				if(distanceFired > 300) {
					fired = false;
					distanceFired = 0;
					firex = mainx;
					firey = mainy;
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
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(end) {
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
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(end) {
		if (e.getKeyCode() == KeyEvent.VK_D) {
			right = false;
			mainboy = new ImageIcon("src/eggdefaultsmallsmallright.png");
			mainim = mainboy.getImage();
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			down = false;
			mainboy = new ImageIcon("src/eggdefaultsmallsmallright.png");
			mainim = mainboy.getImage();
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			left = false;
			mainboy = new ImageIcon("src/eggdefaultsmallsmallright.png");
			mainim = mainboy.getImage();
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			up = false;
			mainboy = new ImageIcon("src/eggdefaultsmallsmallright.png");
			mainim = mainboy.getImage();
		}
	}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
