package gameObjects;

import java.awt.*;

public class Ball extends GameObject {

    private int ballX;
    private int ballY;
    private int ballSpeedX = 2;
    private int ballSpeedY = 1;
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
        if (ballX <= PlayerPaddle.width*2) {
            if ((ballY+radius >= playerPaddle.getY()) && (ballY - radius <= playerPaddle.getY() + PlayerPaddle.height)) {
                reverseX();
            } else {
                score2++;
                resetBall();
                playerPaddle.reset();
                aiPaddle.reset();
            }
        }
        if (ballX >= W - AIPaddle.width - radius) {
            if ((ballY + radius >= aiPaddle.getY()) && (ballY - radius <= aiPaddle.getY() + AIPaddle.height )) {
                reverseX();
            } else {
                score1++;
                resetBall();
                playerPaddle.reset();
                aiPaddle.reset();
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
        ballSpeedX = ballSpeedX * -1;
        ballSpeedY = ballSpeedY * 1;
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