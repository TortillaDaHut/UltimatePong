package gameObjects;
import java.awt.*;
import java.awt.event.*;
import java.time.Duration;

public class AIPaddle extends Paddle {
    
    public AIPaddle() {
    }

        // Method to update the position of the paddle based on the ball's position
    public void updateAIPaddle(PlayerBall ball, Duration deltaTime) {
        if (ball.getBallY() < getY()) {
            moveUp(deltaTime);
        } else if (ball.getBallY() > getY() + Paddle.HEIGHT) {
            moveDown(deltaTime);
        }
    }
    
    	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(Color.RED);
		g.fillRect(W-width, y, width, height);
	}
   
}
