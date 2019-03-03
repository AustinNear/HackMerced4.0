package HealthyChoices;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Start extends JPanel implements KeyListener, ActionListener {
	private boolean space = false;
	private Timer timer;
	private int delay = 75;
	private Image image;
	private int mainwidth;
    private int mainheight;
    private ImageObserver imageobserver;
	public Start() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}

	public void paint(Graphics graphics) {
		 ImageIcon start = new ImageIcon("src/start.png");
		 Color color = new Color(20, 40, 55, 0);
	       image = start.getImage(); 
	       mainwidth = image.getWidth(null);
	       mainheight = image.getHeight(null);
	       graphics.drawImage(image, 0, 0, mainwidth, mainheight, color, imageobserver); 
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			WindowMain.changemode(true);
			timer.stop();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
