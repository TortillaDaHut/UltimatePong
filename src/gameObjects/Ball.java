package gameObjects;

import java.awt.*;

public class Ball extends GameObject{
	//Ball instance variables
	private int ballX = W/2;
	private int ballY = H/2;
	private int ballSpeedX = 3;
	private int ballSpeedY = 2;


	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(Color.ORANGE);
		g.fillOval(ballX, ballY, 5, 5);
	}
}
