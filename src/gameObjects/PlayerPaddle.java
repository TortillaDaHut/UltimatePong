package gameObjects;

import java.awt.*;
import java.awt.event.*;

public class PlayerPaddle extends Paddle implements KeyListener {

    private PongGame pongGame; // Reference to the PongGame panel
    

    public PlayerPaddle(PongGame pongGame) {
        this.pongGame = pongGame;
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W) {
            upPressed = true; // Set the upPressed flag to true
        } else if (keyCode == KeyEvent.VK_S) {
            downPressed = true; // Set the downPressed flag to true
        } // Repaint the PongGame panel
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W) {
            upPressed = false; // Set the upPressed flag to false
        } else if (keyCode == KeyEvent.VK_S) {
            downPressed = false; // Set the downPressed flag to false
        }
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

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used but needed to prevent errors
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.BLUE);
        g.fillRect(0, y, width, height);
    }
}
