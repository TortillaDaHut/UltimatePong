package gameObjects;

import java.awt.*;

public class Ball extends GameObject {

    private int ballX;
    private int ballY;
    private int ballSpeedX = 3;
    private int ballSpeedY = 2;
    private int radius = 10;
    
    private PlayerPaddle playerPaddle;
    private AIPaddle aiPaddle;
    public int score1;
    public int score2;

    public Ball(PlayerPaddle playerPaddle, AIPaddle aiPaddle, int score1, int score2) {
        this.playerPaddle = playerPaddle;
        this.aiPaddle = aiPaddle;
        this.score1 = score1;
        this.score2 = score2;

        // Initializes ball position
        ballX = W / 2;
        ballY = H / 2;
    }

    public int getBallY() {
        return ballY;
    }

    public void move() {
        changeX();
        changeY();
    }

    public void changeX() {
        if (ballX <= PlayerPaddle.width) {
            if ((ballY >= playerPaddle.getY()) && (ballY <= playerPaddle.getY() + PlayerPaddle.height)) {
                reverseX();
            } else {
                score2++;
                resetBall();
            }
        }
        if (ballX >= W - AIPaddle.width - radius) {
            if ((ballY >= aiPaddle.getY()) && (ballY <= aiPaddle.getY() + AIPaddle.height)) {
                reverseX();
            } else {
                score1++;
                resetBall();
            }
        }
        ballX += ballSpeedX;
    }

    public void changeY() {
        if (ballY < radius || ballY > H - radius) {
            reverseY();
        }
        ballY += ballSpeedY;
    }

    public void resetBall() {
        ballX = W / 2;
        ballY = H / 2;
        ballSpeedX = 3;
        ballSpeedY = 2;
    }

    public void reverseX() {
        ballSpeedX = -ballSpeedX;
    }

    public void reverseY() {
        ballSpeedY = -ballSpeedY;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillOval(ballX - radius, ballY - radius, 2 * radius, 2 * radius);
    }
}