package gameObjects;

import java.awt.*;

public class Paddle extends GameObject {

	//Paddle position and hitbox variables
	public static final int width = 10;
	public static final int height = 80;
	public static final int speed = 5;
   
   public boolean upPressed = false;
	public boolean downPressed = false;
      
	public int y = H/2 - height/2;


   public int getY() {
       return y;
   }
  
   public int getWidth() {
       return width;
   }
   
   public int getHeight() {
       return height;
   }

   public void moveUp() {
       if (y>(0)){
            y -= speed; // Decrease y-coordinate to move up
       }
   }

    public void moveDown() { 
        if (y<(H-height)){
            y += speed; // Increase y-coordinate to move down
        }
    }

    public void setUpPressed(boolean pressed) {
        this.upPressed = pressed;
    }

    public void setDownPressed(boolean pressed) {
        this.downPressed = pressed;
    }
    
    public void reset() {
    	y = H/2 - height/2;
    }
    
}
