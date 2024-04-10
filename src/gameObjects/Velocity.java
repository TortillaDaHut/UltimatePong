package gameObjects;

public class Velocity {
	
	protected double speed;
	protected double[] dir;
	
	public Velocity() {
		speed = 0;
		dir = new double[2];
	}
	
	public Velocity(double x, double y) {
		
		speed = calcSpeed(x,y);
		
		this.dir = new double[2];
		
		dir[0] = x/speed;
		dir[1] = y/speed;
		
	}
	
	
	private double calcSpeed(double x, double y) {
		return Math.sqrt(x*x + y*y);
	}
	
	public double getY() {
		return dir[1] * speed;
	}
	
	public double getX() {
		return dir[0] * speed;
	}
	
	public void setX(double newX) {
		double x = newX;
		double y = dir[1] * speed;
		
		speed = calcSpeed(x,y);
		dir[0] = x/speed;
		dir[1] = y/speed;
	}
	
	public void setY(double newY) {
		double x = dir[0] * speed;
		double y = newY;
		
		speed = calcSpeed(x,y);
		dir[0] = x/speed;
		dir[1] = y/speed;
	}
	
	public void addX(double x) {
		setX(speed * dir[0] + x);
	}
	
	public void addY(double y) {
		setY(speed * dir[1] + y);
	}
	
	public void addSpeed(double speed) {
		this.speed += speed;
	}
	
	public void multX(double x) {
		setX(speed * dir[0] * x);
	}
	
	public void multY(double y) {
		setY(speed * dir[1] * y);
	}
	
	public void multSpeed(double speed) {
		this.speed *= speed;
	}
	
	
	
	

}
