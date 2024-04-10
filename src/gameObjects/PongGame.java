package gameObjects;

import java.awt.*;
import java.time.Duration;
import java.time.Instant;

import javax.swing.*;

public class PongGame extends JPanel {

    public PlayerPaddle playerPaddle;
    public AIPaddle aiPaddle;
    public PlayerBall ball;
    public Duration deltaTime;
    public Instant beginTime;

    public PongGame() {
        setPreferredSize(new Dimension(GameObject.W, GameObject.H));
        setBackground(Color.BLACK);

        playerPaddle = new PlayerPaddle(this);
        add(playerPaddle);

        aiPaddle = new AIPaddle();
        add(aiPaddle);
        
        ball = new PlayerBall(playerPaddle, aiPaddle, 0, 0);
        deltaTime = Duration.between(Instant.now(), Instant.now());
    }
    
    @Override
    public void paintComponent(Graphics g) {
    	beginTime = Instant.now();
        super.paintComponent(g);
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + ball.score1, 20, 30);
        g.drawString("Score: " + ball.score2, GameObject.W-100, 30);
        
        
        
        
        gameLoop(g, deltaTime);
        
        repaint();
        
        deltaTime = Duration.between(beginTime, Instant.now());
      
    }
    
    public void gameLoop(Graphics g, Duration deltaTime) {
    	playerPaddle.updatePaddle(deltaTime);
        playerPaddle.paint(g);
        ball.move(deltaTime);
        ball.paint(g);
        aiPaddle.paint(g);
        aiPaddle.updateAIPaddle(ball,deltaTime);
    }
}

