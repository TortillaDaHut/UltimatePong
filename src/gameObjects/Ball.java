package gameObjects;

import java.awt.*;

public class Ball extends GameObject {

    private int ballX;
    private int ballY;
    private int ballSpeedX = 7;
    private int ballSpeedY = 5;
    private int radius = 10;
    
    private PlayerPaddle playerPaddle;
    private AIPaddle aiPaddle;
    public int score1;
    public int score2;
    public Sound sound = new Sound();

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
            sound.playSound(0);
            if ((ballY >= playerPaddle.getY()) && (ballY <= playerPaddle.getY() + PlayerPaddle.height)) {
                reverseX();
            } else {
                score2++;
                resetBall();
            }
        }
        if (ballX >= W - AIPaddle.width - radius) {
            sound.playSound(0);
            if ((ballY >= aiPaddle.getY()) && (ballY <= aiPaddle.getY() + AIPaddle.height )) {
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
            sound.playSound(0);
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
