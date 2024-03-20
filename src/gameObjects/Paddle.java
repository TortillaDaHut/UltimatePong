package gameObjects;

import java.awt.*;

public class Paddle extends GameObject {

	//Paddle position and hitbox variables n shi
	public static final int width = 10;
	public static final int height = 80;
	public static final int speed = 5;

	public int y = H/2 - height/2;




	//These are used in movement. May have to switch where they are. UML diagram will help for sure.
	private boolean upPressed = false;
	private boolean downPressed = false;

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(Color.BLUE);
		g.fillRect(0, y, width, height);
	}


}
