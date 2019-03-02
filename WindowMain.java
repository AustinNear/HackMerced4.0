package HealthyChoices;


import javax.swing.JFrame;
import javax.swing.JTextArea;

public class WindowMain {
	public static JFrame Window = new JFrame();
	public static Gameplay game = new Gameplay();
	public static void main (String[] args) {
		Window.setBounds(0, 0, 905, 700);			
		Window.setResizable(false);
		Window.setTitle("Healthy Choices");
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JTextArea textArea = new JTextArea();
	    textArea.setText("Click Me!");
		Window.add(game);
		Window.setVisible(true);
	}
}