package gameObjects;
import java.awt.*;
import java.awt.event.*;

public class AIPaddle extends Paddle {
    
    public AIPaddle() {
    }

        // Method to update the position of the paddle based on the ball's position
    public void updateAIPaddle(Ball ball) {
        if (ball.getBallY() < getY()) {
            moveUp();
        } else if (ball.getBallY() > getY() + Paddle.HEIGHT) {
            moveDown();
        }
    }
    
    	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(Color.RED);
		g.fillRect(W-width, y, width, height);
	}
   
}
