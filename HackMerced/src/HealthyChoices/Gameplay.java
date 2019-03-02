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
    private ImageObserver imageobserver;
    private int mainx = 300;
    private int mainy = 300;
    private boolean right;
    private boolean up;
    
	public Gameplay() {
		addKeyListener(this);					//Makes the key listener and timer when the game object is created
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
	
	public void paint(Graphics graphics) {
		   Color color = new Color(0, 255, 0, 255);
		   ImageIcon mainboy = new ImageIcon("src/main_character.png");
	       image = mainboy.getImage(); 
	       mainwidth = image.getWidth(null);
	       mainheight = image.getHeight(null);
	       graphics.setColor(color);
	       graphics.fillRect(0, 0, 10000, 10000);
	       graphics.drawImage(image, mainx, mainy, mainwidth, mainheight, color, imageobserver);
	       graphics.dispose();
	}
	
	@Override
	
	public void actionPerformed(ActionEvent e) {
		if(right && up){ //move northeast if D and W is pressed simultaneously
			mainy += -10;
			mainx += 10;
			repaint();
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
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D) {
			right = false;	
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {
			up = false;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

}