package gameObjects;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;


public class AIPaddle extends Paddle {
    
    private boolean AIPlayer; // Add a field to store AIPlayer value

    // Array of paddle images
    Image[] images = new Image[3];
    Random random = new Random();
    int randomNumber = random.nextInt(3);
    
    public AIPaddle(PongGame pongGame, boolean AIPlayer) {
        this.AIPlayer = AIPlayer; // Initialize AIPlayer field
        images[0] = new ImageIcon("./goldPaddleImg.png").getImage();
        images[1] = new ImageIcon("./hotDogImg.png").getImage();
        images[2] = new ImageIcon("./capsuleImg.png").getImage();
    }

    // Method to update the position of the paddle based on the ball's position
    public void updateAIPaddle(Ball ball) {
        if (AIPlayer && ((ball.getBallSpeedX() > 0) || ball.getBallX() > W/3)) {
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
        super.paintComponent(g);
        g.drawImage(images[randomNumber], 790, y, null);
    }
}
