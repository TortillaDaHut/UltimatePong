package gameObjects;

import java.awt.*;
import javax.swing.*;

/* This is the runner file because I needed to put this code somewhere. The instance is constructed in the main method. */
public class PongGame extends JPanel {
	public PongGame() {

		setPreferredSize(new Dimension(GameObject.W, GameObject.H));
		setBackground(Color.BLACK);
	}
/* I couldn't get this method to work before I'm publishing, but it's what displays the paddles
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.BLUE);
		g.fillRect(0,paddleY, pW, pH);

		g.setColor(Color.RED);
		g.fillRect(W - pW, paddle2Y, pW, pH);
	}

 */




}
