package gameObjects;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class PlayerPaddle extends Paddle {
    
    // Instantiation of images as global variables
    Image[] images = new Image[3];
    Random random = new Random();
    int randomNum = random.nextInt(3);
    
       public PlayerPaddle(PongGame pongGame) {
        // No need to initialize pongGame or addKeyListener anymore
           images[0] = new ImageIcon("./goldPaddleImg.png").getImage();
           images[1] = new ImageIcon("./hotDogImg.png").getImage();
           images[2] = new ImageIcon("./capsuleImg.png").getImage();
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
        super.paintComponent(g);
        g.drawImage(images[randomNum], 0, y, null);
    }
}
