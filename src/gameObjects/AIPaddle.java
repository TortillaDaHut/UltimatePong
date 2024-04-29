package gameObjects;

import java.awt.*;

public class AIPaddle extends Paddle {
    
    private boolean AIPlayer; // Add a field to store AIPlayer value

    public AIPaddle(PongGame pongGame, boolean AIPlayer) {
        this.AIPlayer = AIPlayer; // Initialize AIPlayer field
    }

    // Method to update the position of the paddle based on the ball's position
    public void updateAIPaddle(Ball ball) {
        if (AIPlayer && ball.getBallX() > W/3) {
            if (ball.getBallY() < getY()) {
                moveUp();
            } else if (ball.getBallY() > getY() + Paddle.HEIGHT) {
                moveDown();
            }
        } else {
            if (upPressed) {
                moveUp();
            }
            if (downPressed) {
                moveDown();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.RED);
        g.fillRect(790, y, width, height);
    }
}
