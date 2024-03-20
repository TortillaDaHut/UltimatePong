package gameObjects;

import java.awt.*;
import javax.swing.*;

/* This is the runner file because I needed to put this code somewhere. The instance is constructed in the main method. */
public class PongGame extends JPanel {

	public Paddle paddle;
	public Ball ball;
	public PongGame() {
		setPreferredSize(new Dimension(GameObject.W, GameObject.H));

		setBackground(Color.BLACK);

		paddle = new Paddle();
		ball = new Ball();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		ball.paint(g);
		paddle.paint(g);

	}
}
