package HealthyChoices;


import javax.swing.JFrame;

public class WindowMain {
	public static JFrame Window = new JFrame();
	public static Gameplay game = new Gameplay();
	public static Start start = new Start();
	public static void main (String[] args) {
		Window.setBounds(0, 0, 905, 700);	
		Window.add(start);
		Window.setVisible(true);		
		Window.setResizable(false);
		Window.setTitle("Healthy Bobo");
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void changemode(boolean a) {
		if(a) {
			Window.setVisible(false);
			Window.remove(start);
			Window.add(game);
			Window.setVisible(true);
		}
		
	}
}
