package gameObjects;
import gameObjects.*;

import java.awt.*;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {

		//JFrame stuff I got off internet and I didn't change any of it
		JFrame frame = new JFrame("Ultimate Pong");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new PongGame());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}


