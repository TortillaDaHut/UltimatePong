package gameObjects;

import java.awt.*;
import java.time.Duration;

public class PlayerBall extends GameObject {

	private int ballX;
    private int ballY;
    private Velocity velocity;
    
    int maxX = 6;
    int maxY = 4;
    
    private int radius = 10;
    
    protected PlayerPaddle playerPaddle;
    protected AIPaddle aiPaddle;
    public int score1;
    public int score2;

    public PlayerBall(PlayerPaddle playerPaddle, AIPaddle aiPaddle, int score1, int score2) {
        this.playerPaddle = playerPaddle;
        this.aiPaddle = aiPaddle;
        this.score1 = score1;
        this.score2 = score2;
        
        int x = (int)(Math.random()*2) == 0 ? -3 : 3;
        
        int y = (int)(Math.random()*2) == 0 ? -2 : 2;
        
        velocity = new Velocity(x,y);

        // Initializes ball position
        ballX = W / 2;
        ballY = H / 2;
    }

    public int getBallY() {
        return ballY;
    }

    public void move(Duration deltaTime) {
        changeX(deltaTime);
        changeY(deltaTime);
    }

    public void changeX(Duration deltaTime) {

        if (ballX <= PlayerPaddle.width) {
            if ((ballY >= playerPaddle.getY()) && (ballY <= playerPaddle.getY() + PlayerPaddle.height)) {
            	
            	
            	double relativeY = ballY - playerPaddle.getY();
            	
            	relativeY = (relativeY-0) / (playerPaddle.y+PlayerPaddle.height - 0) * (0.5 - -0.5 ) + -0.5;
            	
            	if(!(relativeY < 0 && velocity.getY() > 0 || relativeY > 0 && velocity.getY() < 0)) {
            		
            		if(relativeY < 0) {
            			velocity.multY(-0.8 + relativeY);
            		} else {
            			velocity.multY(0.8 + relativeY);
            		}
            		
            		
            	}
            	
                reverseX();
            } else {
                score2++;
                resetBall(1);
            }
        }
      
        if (ballX >= W - AIPaddle.width - radius) {
            if ((ballY >= aiPaddle.getY()) && (ballY <= aiPaddle.getY() + AIPaddle.height)) {
            	
            	
            	double relativeY = ballY - aiPaddle.getY();
            	
            	relativeY = (relativeY-0) / (aiPaddle.y+AIPaddle.height - 0) * (0.5 - -0.5 ) + -0.5;
            	
            	if(!(relativeY < 0 && velocity.getY() > 0 || relativeY > 0 && velocity.getY() < 0)) {
            		
            		if(relativeY < 0) {
            			velocity.multY(-0.8 + relativeY);
            		} else {
            			velocity.multY(0.8 + relativeY);
            		}
            		
            	}	
            	
            	
            	
                reverseX();
            } else {
                score1++;
                resetBall(0);
            }
        }
        clampSpeed();
        ballX += (velocity.getX() + .5)* deltaTime.getNano()/1000000;
    }
    

    public void changeY(Duration deltaTime) {
        if (ballY < radius || ballY > H - radius) {
            reverseY();
        }
        ballY += (velocity.getY() + .5) * deltaTime.getNano()/1000000;
    }

    public void resetBall(int winner) {
        ballX = W / 2;
        ballY = H / 2;
        
        int ballSpeed = (int)(Math.random()*3) + 2;
        
        int x = (winner == 1) ? (3) : (-3);
        
        int y = ((int)(Math.random()*2) == 0) ? (ballSpeed) : (-ballSpeed);
        
        velocity = new Velocity(x,y);
        
    }

    public void reverseX() {
        velocity.multX(-1);
    }

    public void reverseY() {
        velocity.multY(-1);
    }
    
    public void clampSpeed() {
    	
    	
    	if(Math.abs(velocity.getY()) > maxY) {
    		velocity.setY(Integer.signum((int)velocity.getY()) * maxY);
    	}
    	
    	if(Math.abs(velocity.getX()) > maxX) {
    		velocity.setX(Integer.signum((int)velocity.getX()) * maxX);
    	}
    	
    	
    }
    

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillOval(ballX - radius, ballY - radius, 2 * radius, 2 * radius);
    }

}