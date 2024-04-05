package gameObjects;

import java.awt.*;
import javax.swing.*;

public class PongGame extends JPanel {

    public PlayerPaddle playerPaddle;
    public AIPaddle aiPaddle;
    public Ball ball;

    public PongGame() {
        setPreferredSize(new Dimension(GameObject.W, GameObject.H));
        setBackground(Color.BLACK);

        playerPaddle = new PlayerPaddle(this);
        add(playerPaddle);

        aiPaddle = new AIPaddle();
        add(aiPaddle);
        
        ball = new Ball(playerPaddle, aiPaddle, 0, 0);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + ball.score1, 20, 30);
        g.drawString("Score: " + ball.score2, GameObject.W-100, 30);
        
        
        
        
        gameLoop(g);
        
        repaint();
      
    }
    
    public void gameLoop(Graphics g) {
    	playerPaddle.updatePaddle();
        playerPaddle.paint(g);
        ball.move();
        ball.paint(g);
        aiPaddle.paint(g);
        aiPaddle.updateAIPaddle(ball);
    }
}

