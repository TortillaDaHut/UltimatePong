package gameObjects;

import java.awt.*;

public class PlayerPaddle extends Paddle {
       public PlayerPaddle(PongGame pongGame) {
        // No need to initialize pongGame or addKeyListener anymore
    }

    // Method to continuously check for key presses and update paddle position
    public void updatePaddle() {
            if (upPressed) {
                moveUp();
            }
            if (downPressed) {
                moveDown();
            }
    }

    public void paints(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        g.fillRect(0, y, width, height);
    }
}
