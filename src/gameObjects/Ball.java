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
    public Sound sound = new Sound();

    public Ball(PlayerPaddle playerPaddle, AIPaddle aiPaddle, int score1, int score2) {
        this.playerPaddle = playerPaddle;
        this.aiPaddle = aiPaddle;
        this.score1 = score1;
        this.score2 = score2;
        ballSpeedY = 4;
        ballSpeedX = 3;
        // Initializes ball position
        ballX = W / 2;
        ballY = H / 2;
    }

    public int getBallY() {
        return ballY;
    }
    
    public int getBallX() {
    	return ballX;
    }

    public void move() {
        changeX();
        changeY();
    }

    public void changeX() {
        if (ballX <= PlayerPaddle.width*2) {
            sound.playSound(0);
            if ((ballY+radius >= playerPaddle.getY()) && (ballY-radius <= playerPaddle.getY() + PlayerPaddle.height)) {
                reverseX();
            } else {
                score2++;
                resetBall();
            }
        }
        if (ballX >= W - AIPaddle.width - radius) {
            sound.playSound(0);
            if ((ballY+radius >= aiPaddle.getY()) && (ballY-radius <= aiPaddle.getY() + AIPaddle.height )) {
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


    
    
	public void setBallSpeedX(int ballSpeedX) {
		this.ballSpeedX = ballSpeedX;
	}


	public void setBallSpeedY(int ballSpeedY) {
		this.ballSpeedY = ballSpeedY;
	}

	public int getBallSpeedX() {
		return ballSpeedX;
	}

	public int getBallSpeedY() {
		return ballSpeedY;
	}
    
}
