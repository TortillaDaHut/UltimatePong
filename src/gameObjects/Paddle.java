package gameObjects;

import java.awt.*;
import java.time.Duration;

public class Paddle extends GameObject {

	//Paddle position and hitbox variables n shi
	public static final int width = 10;
	public static final int height = 80;
	public static final int speed = 5;

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

	//These are used in movement. May have to switch where they are. UML diagram will help for sure.
	public boolean upPressed = false;
	public boolean downPressed = false;
   
   public void moveUp(Duration deltaTime) {
       if (y>(0)){
            y -= speed * deltaTime.getNano()/1000000; // Decrease y-coordinate to move up
    }}

    public void moveDown(Duration deltaTime) { 
        if (y<(H-height)){
            y += speed * deltaTime.getNano()/1000000; // Increase y-coordinate to move down
    }}

}
